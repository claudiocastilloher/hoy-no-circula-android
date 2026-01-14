package com.example.hoynocirculacdmx.presentation.main

import com.example.hoynocirculacdmx.domain.model.StickerColor

/**
 *  Estado que representa lo que la pantalla principal necesita mostrar
 *  La UI solo lee este estado, nunca aplica lógica
 */

data class MainUiState(
    val dayName: String = "",
    val stickerColor: StickerColor = StickerColor.AZUL,
    val restrictedPlates: List<Int> = emptyList()
)
