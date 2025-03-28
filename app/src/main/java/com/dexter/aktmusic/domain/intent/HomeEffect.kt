package com.dexter.aktmusic.domain.intent

sealed interface HomeEffect {
    data class ShowToast(val message: String) : HomeEffect
    data class NavigateTo(val destination: String) : HomeEffect
    data class PlaybackError(val error: String) : HomeEffect
}