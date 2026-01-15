package com.example.hoynocirculacdmx.domain.usecase
import com.example.hoynocirculacdmx.domain.model.DayRestriction
import com.example.hoynocirculacdmx.domain.model.Hologram
import com.example.hoynocirculacdmx.domain.model.StickerColor
import com.example.hoynocirculacdmx.domain.rules.StickerRules
import com.example.hoynocirculacdmx.domain.rules.WeeklyRestrictionRule
import java.time.Clock
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

/**
 *  Caso de uso central que determina la restricción de circulación
 *  para el día actual, considerando:
 *  - Dia de la semana
 *  - Engomado (por placa)
 *  - Holograma
 *
 *  No depende de Android ni de UI
 *
 */

class GetTodayRestrictionUseCase(
    private val clock: Clock = Clock.systemDefaultZone()
) {

    /**
     * Ejecuta el caso de uso.
     *
     * @param plateLastDigit último dígito de la placa
     * @param holograma holograma del vehículo
     */

    fun execute(
        plateLastDigit: Int,
        holograma: Hologram
    ): DayRestriction {
        val today = LocalDate.now(clock)
        val dayOfWeek = today.dayOfWeek

        // Regla 1: obtener engomado por placa
        val stickerColor = StickerRules.fromPlateLastDigit(plateLastDigit)

        // Regla 2: engomado restringido por día
        val restrictedSticker =
            WeeklyRestrictionRule.restrictedStickerFor(dayOfWeek)

        // Regla 3: decisión final
        val isRestricted = when {
            restrictedSticker == null -> false //fin de semana
            holograma.permiteCircularSiempre() -> false
            restrictedSticker == stickerColor -> true
            else -> false
        }

        return DayRestriction(
            dayOfWeek = dayOfWeek,
            stickerColor = stickerColor,
            isRestricted = isRestricted
        )
    }

}

































