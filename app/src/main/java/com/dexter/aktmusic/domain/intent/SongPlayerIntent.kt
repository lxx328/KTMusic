package com.dexter.aktmusic.domain.intent

sealed class SongPlayerIntent {
    data class PlaySongById(val songId: Boolean) : SongPlayerIntent()
    object PlaySong : SongPlayerIntent()
}