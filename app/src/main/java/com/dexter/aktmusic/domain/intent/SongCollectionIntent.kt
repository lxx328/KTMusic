package com.dexter.aktmusic.domain.intent

sealed class SongCollectionIntent {
    data class ConfirmSongCollectionById(val genre: Int) : SongCollectionIntent()
    data class CancelSongCollectionById(val genre: Int) : SongCollectionIntent()
    object GetSongCollection : SongCollectionIntent()
}