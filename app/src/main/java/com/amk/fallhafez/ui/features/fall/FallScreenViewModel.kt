package com.amk.fallhafez.ui.features.fall

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amk.fallhafez.model.data.Res2
import com.amk.fallhafez.model.data.Result
import com.amk.fallhafez.model.repository.FallRepository
import kotlinx.coroutines.launch

class FallScreenViewModel(
    private val fallRepository: FallRepository
) : ViewModel() {
    val fallTabir = mutableStateOf<List<Res2>>(listOf())
    val fallGhazal = mutableStateOf<List<Result>>(listOf())

    fun getFallGhazal(){
        viewModelScope.launch {
            val ghazal = fallRepository.getFallGhazal()
            fallGhazal.value = ghazal
        }
    }

    fun getFallTabir() {
        viewModelScope.launch {
            val tabir =  fallRepository.getFallTabir()
            fallTabir.value = tabir
        }
    }
}