package com.example.hoynocirculacdmx.domain.rules

import com.example.hoynocirculacdmx.domain.model.StickerColor
import java.time.DayOfWeek

object WeeklyRestrictionRule {

    fun restrictedStickerFor(day: DayOfWeek): StickerColor?{
        return when (day){
            DayOfWeek.MONDAY -> StickerColor.AMARILLO
            DayOfWeek.TUESDAY -> StickerColor.ROSA
            DayOfWeek.WEDNESDAY -> StickerColor.ROJO
            DayOfWeek.THURSDAY -> StickerColor.VERDE
            DayOfWeek.FRIDAY -> StickerColor.AZUL
            else -> null // Sábado y domingo no aplican aquí
        }
    }

}