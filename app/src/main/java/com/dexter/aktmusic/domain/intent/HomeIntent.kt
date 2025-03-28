package com.dexter.aktmusic.domain.intent

import com.dexter.aktmusic.domain.state.Tab

sealed interface HomeIntent {
    object PlayPause : HomeIntent
    object Next : HomeIntent
    object Previous : HomeIntent
    data class SeekTo(val position: Float) : HomeIntent
    data class SelectTab(val tab: Tab) : HomeIntent
    object ToggleFavorite : HomeIntent
    object ToggleDrawer : HomeIntent
}