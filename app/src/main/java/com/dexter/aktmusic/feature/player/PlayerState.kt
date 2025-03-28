package com.dexter.aktmusic.feature.player

import com.dexter.aktmusic.base.mvi.MviState
import com.dexter.aktmusic.data.model.home.DSong

data class PlayerState(
    val currentSong: DSong? = null,
    val isPlaying: Boolean = false,
    val progress: Float = 0f,
    val duration: Long = 0L,
    val playlist: List<DSong> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) : MviState 