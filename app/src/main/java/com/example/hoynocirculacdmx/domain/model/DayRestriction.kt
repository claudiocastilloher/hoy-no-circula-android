package com.example.hoynocirculacdmx.domain.model

/**
 *  Representa la restricción de circulacion para un día específico.
 *
 * @property dayName Nombre del día (ej. Lunes)
 * @property stickerColor Color del engomado correspondiente
 * @property restrictedPlates Lista de terminaciones de placa que NO circulan
 */

data class DayRestriction(
    val dayName : String,
    val stickerColor: StickerColor,
    val restrictedPlates: List<Int>
)