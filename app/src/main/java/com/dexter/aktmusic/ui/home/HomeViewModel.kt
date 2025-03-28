package com.dexter.aktmusic.ui.home

import com.dexter.aktmusic.base.mvi.BaseViewModel
import com.dexter.aktmusic.feature.player.PlayerEffect
import com.dexter.aktmusic.feature.player.PlayerIntent
import com.dexter.aktmusic.feature.player.PlayerState

class HomeViewModel(initialState: PlayerState) : BaseViewModel<PlayerState, PlayerIntent, PlayerEffect>(
    initialState
){
    override fun processIntent(intent: PlayerIntent) {
        TODO("Not yet implemented")
    }
}