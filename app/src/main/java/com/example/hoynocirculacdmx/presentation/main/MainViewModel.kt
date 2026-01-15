package com.example.hoynocirculacdmx.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hoynocirculacdmx.domain.model.Holograma
import com.example.hoynocirculacdmx.domain.usecase.GetTodayRestrictionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.format.TextStyle
import java.util.Locale

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
            val restriction = getTodayRestrictionUseCase.execute(
                plateLastDigit = 5, //ejemplo
                holograma = Holograma.ONE //ejemplo
            )

            val locale = Locale.Builder()
                .setLanguage("es")
                .setRegion("MX")
                .build()

            // Presentación: nombre del día en español
            val dayName = restriction.dayOfWeek
                .getDisplayName(TextStyle.FULL, locale)
                .replaceFirstChar { it.uppercase() }

            _uiState.value = MainUiState(
                dayName = dayName,
                stickerColor = restriction.stickerColor,
                isRestricted = restriction.isRestricted
            )
        }
    }


}