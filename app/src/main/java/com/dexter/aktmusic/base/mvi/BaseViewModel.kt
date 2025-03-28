package com.dexter.aktmusic.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<STATE : MviState, INTENT : MviIntent, EFFECT : MviEffect>(
    initialState: STATE
) : ViewModel(), ContainerHost<STATE, EFFECT> {

    override val container: Container<STATE, EFFECT> = container(initialState)

    abstract fun processIntent(intent: INTENT)

    protected fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            block()
        }
    }
} 