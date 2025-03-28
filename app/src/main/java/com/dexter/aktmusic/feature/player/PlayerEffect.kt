package com.dexter.aktmusic.feature.player

import com.dexter.aktmusic.base.mvi.MviEffect

sealed interface PlayerEffect : MviEffect {
    data class ShowToast(val message: String) : PlayerEffect
    data class NavigateToPlaylist(val playlistId: String) : PlayerEffect
    data object ShowMiniPlayer : PlayerEffect
    data object HideMiniPlayer : PlayerEffect
    data class ShowError(val error: String) : PlayerEffect
} 