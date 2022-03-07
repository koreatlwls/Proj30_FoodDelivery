package com.example.proj30_fooddelivery.screen.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected var stateBundle: Bundle? = null

    open fun fetchData(): Job = viewModelScope.launch { }

    open fun storeStae(staeBundle: Bundle) {
        this.stateBundle = stateBundle
    }
}