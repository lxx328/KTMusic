package com.dexter.aktmusic.domain.usecase.player

import com.dexter.aktmusic.data.model.home.DSong
import javax.inject.Inject

class PlaySongUseCase @Inject constructor() {
    suspend operator fun invoke(song: DSong) {
        // TODO: Implement actual song playback logic here
        // For now, we'll just validate the song data
        if (song.songUrl.isBlank()) {
            throw IllegalArgumentException("Song URL cannot be empty")
        }
        if (song.songId.isBlank()) {
            throw IllegalArgumentException("Song ID cannot be empty")
        }
    }
} 