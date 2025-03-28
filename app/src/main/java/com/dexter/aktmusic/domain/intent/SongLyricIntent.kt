package com.dexter.aktmusic.domain.intent

sealed class SongLyricIntent {
    data class CancelSongLyricById(val songId: Int) : SongLyricIntent()
    data class ConfirmSongLyricById(val songId: Int) : SongLyricIntent()
    object GetSongLyric : SongLyricIntent()
}