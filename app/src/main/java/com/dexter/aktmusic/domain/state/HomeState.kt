package com.dexter.aktmusic.domain.state

import com.dexter.aktmusic.data.model.home.DSong

// 首页的完整状态
data class HomeState(
    val currentSong: DSong? = null,
    val playState: PlayState = PlayState.STOPPED,
    val currentLyric: String = "",
    val isFavorite: Boolean = false,
    val currentPlayProgress: Float = 0f,
    val isDrawerOpen: Boolean = false,
    val selectedTab: Tab = Tab.HOME
)