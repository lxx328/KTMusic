package com.dexter.aktmusic.domain.intent

import com.dexter.aktmusic.domain.state.Tab

sealed interface HomeIntent {
    data class SeekTo(val position: Float) : HomeIntent
    data class SelectTab(val tab: Tab) : HomeIntent
    data object ToggleFavorite : HomeIntent
}