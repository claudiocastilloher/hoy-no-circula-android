package com.example.hoynocirculacdmx.domain.model

import androidx.compose.ui.graphics.Color

/**
 * Convierte el color del dominio en un color usable por Compose.
 * La UI decide cómo se ve, el dominio solo decide qué color es.
 */

fun StickerColor.toComposeColor(): Color =
    when (this) {
        StickerColor.AMARILLO -> Color(0xFFFFEB3B)
        StickerColor.ROSA -> Color(0xFFE91E63)
        StickerColor.ROJO -> Color(0xFFF44336)
        StickerColor.VERDE -> Color(0xFF4CAF50)
        StickerColor.AZUL -> Color(0xFF2196F3)
    }