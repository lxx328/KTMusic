package com.dexter.aktmusic.feature.player

import com.dexter.aktmusic.base.mvi.MviIntent
import com.dexter.aktmusic.data.model.home.DSong

sealed interface PlayerIntent : MviIntent {
    data class PlaySong(val song: DSong) : PlayerIntent
    data object PauseSong : PlayerIntent
    data object ResumeSong : PlayerIntent
    data object NextSong : PlayerIntent
    data object PreviousSong : PlayerIntent
    data class SeekTo(val position: Float) : PlayerIntent
    data class UpdatePlaylist(val songs: List<DSong>) : PlayerIntent
} 