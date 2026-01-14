package com.example.hoynocirculacdmx.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hoynocirculacdmx.domain.model.StickerColor
import com.example.hoynocirculacdmx.usecase.GetTodayRestrictionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *  ViewModel de la pantalla principal
 *
 *  Responsabilidades:
 *  - Ejecutar el UseCase
 *  - Transformar el resultado en estado de UI
 *  - Exponer un estado observable para Compose
 */

class MainViewModel(
    private val getTodayRestrictionUseCase: GetTodayRestrictionUseCase =
        GetTodayRestrictionUseCase() //luego lo inyectaremos
): ViewModel() {

    // Estado interno mutable
    private val _uiState = MutableStateFlow(MainUiState())

    // Estado público e inmutable
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        loadTodayRestriction()
    }

    /**
     *  Obtiene la restricción del día y actualiza el estado de la UI.
     */

    private fun loadTodayRestriction(){
        viewModelScope.launch {
            val restriction = getTodayRestrictionUseCase.execute()

            _uiState.value = MainUiState(
                dayName = restriction.dayName,
                stickerColor = restriction.stickerColor,
                restrictedPlates = restriction.restrictedPlates
            )
        }
    }


}