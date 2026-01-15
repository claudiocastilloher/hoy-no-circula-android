package com.example.hoynocirculacdmx.domain.model

import java.time.DayOfWeek

/**
 *  Representa la restricción de circulacion para un día específico.
 *
 * @property dayOfWeek Nombre del día (ej. Lunes)
 * @property stickerColor Color del engomado correspondiente
 * @property isRestricted Holograma
 */

data class DayRestriction(
    val dayOfWeek: DayOfWeek,
    val stickerColor: StickerColor,
    val isRestricted: Boolean
)