package com.dexter.aktmusic.data.model.home

/**
 * Created by Dexter on 07/08/23.
 */
data class DSong(
    val songId: String,
    val songName: String = "",
    val songArtist: String = "",
    val songImage: String = "",
    val songUrl: String = "",
    val songLyrics: String = "",
    val songGenre: String = "",
    val songDuration: Long ,
    val songAlbum: String = "",
    val songAlbumImage: String = "",
    val songAlbumUrl: String = "",
    val songCollectSate: Boolean = false
)

