package com.dexter.aktmusic.feature.player

import com.dexter.aktmusic.base.mvi.BaseViewModel
import com.dexter.aktmusic.domain.usecase.player.GetPlaylistUseCase
import com.dexter.aktmusic.domain.usecase.player.PlaySongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val playSongUseCase: PlaySongUseCase,
    private val getPlaylistUseCase: GetPlaylistUseCase
) : BaseViewModel<PlayerState, PlayerIntent, PlayerEffect>(PlayerState()) {

    override fun processIntent(intent: PlayerIntent) {
        when (intent) {
            is PlayerIntent.PlaySong -> handlePlaySong(intent)
            is PlayerIntent.PauseSong -> handlePauseSong()
            is PlayerIntent.ResumeSong -> handleResumeSong()
            is PlayerIntent.NextSong -> handleNextSong()
            is PlayerIntent.PreviousSong -> handlePreviousSong()
            is PlayerIntent.SeekTo -> handleSeekTo(intent)
            is PlayerIntent.UpdatePlaylist -> handleUpdatePlaylist(intent)
        }
    }

    private fun handlePlaySong(intent: PlayerIntent.PlaySong) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        
        try {
            playSongUseCase(intent.song)
            reduce {
                state.copy(
                    currentSong = intent.song,
                    isPlaying = true,
                    isLoading = false
                )
            }
            postSideEffect(PlayerEffect.ShowMiniPlayer)
        } catch (e: Exception) {
            reduce {
                state.copy(
                    error = e.message,
                    isLoading = false
                )
            }
            postSideEffect(PlayerEffect.ShowError(e.message ?: "Unknown error"))
        }
    }

    private fun handlePauseSong() = intent {
        reduce {
            state.copy(isPlaying = false)
        }
    }

    private fun handleResumeSong() = intent {
        reduce {
            state.copy(isPlaying = true)
        }
    }

    private fun handleNextSong() = intent {
        val currentIndex = state.playlist.indexOf(state.currentSong)
        val nextSong = state.playlist.getOrNull(currentIndex + 1)
        
        nextSong?.let {
            processIntent(PlayerIntent.PlaySong(it))
        } ?: postSideEffect(PlayerEffect.ShowToast("No next song available"))
    }

    private fun handlePreviousSong() = intent {
        val currentIndex = state.playlist.indexOf(state.currentSong)
        val previousSong = state.playlist.getOrNull(currentIndex - 1)
        
        previousSong?.let {
            processIntent(PlayerIntent.PlaySong(it))
        } ?: postSideEffect(PlayerEffect.ShowToast("No previous song available"))
    }

    private fun handleSeekTo(intent: PlayerIntent.SeekTo) = intent {
        reduce {
            state.copy(progress = intent.position)
        }
    }

    private fun handleUpdatePlaylist(intent: PlayerIntent.UpdatePlaylist) = intent {
        reduce {
            state.copy(playlist = intent.songs)
        }
    }
} 