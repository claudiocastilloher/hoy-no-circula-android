package com.example.hoynocirculacdmx.domain.usecase
import com.example.hoynocirculacdmx.domain.model.DayRestriction
import com.example.hoynocirculacdmx.domain.model.StickerColor
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

/**
 *  Caso de uso que obtiene la restricción de circulación
 *  correspondiente al día actual, considerando la regla
 *  simplificada del programa Hoy No Circula.
 *
 *  Este UseCase pertenece al dominio:
 *  - No depende de Android
 *  - No conce la UI
 *  - Solo aplica reglas de negocio
 */

class GetTodayRestrictionUseCase {
    /**
     *  Ejecuta el caso de uso.
     *
     *  @return DayRestriction con la información del día actual
     */

    fun execute(): DayRestriction {
        val today = LocalDate.now()
        val dayOfWeek = today.dayOfWeek


        val spanishLocale = Locale.Builder()
            .setLanguage("es")
            .setRegion("ES")
            .build()

        // Nombre del día en español (para mostrar en UI)
        val dayName = dayOfWeek.getDisplayName(
            TextStyle.FULL,
            spanishLocale
        ).replaceFirstChar { it.uppercase() }

        return when (dayOfWeek){
            DayOfWeek.MONDAY -> DayRestriction(
                dayName = dayName,
                stickerColor = StickerColor.AMARILLO,
                restrictedPlates = listOf(5,6)
            )

            DayOfWeek.TUESDAY -> DayRestriction(
                dayName = dayName,
                stickerColor = StickerColor.ROSA,
                restrictedPlates = listOf(7,8)
            )

            DayOfWeek.WEDNESDAY -> DayRestriction(
                dayName = dayName,
                stickerColor = StickerColor.ROJO,
                restrictedPlates = listOf(3,4)
            )

            DayOfWeek.THURSDAY -> DayRestriction(
                dayName = dayName,
                stickerColor = StickerColor.VERDE,
                restrictedPlates = listOf(1,2)
            )

            DayOfWeek.FRIDAY -> DayRestriction(
                dayName = dayName,
                stickerColor = StickerColor.AZUL,
                restrictedPlates = listOf(9,0)
            )

            // Sábado y domingo no aplican restricciones
            else -> DayRestriction(
                dayName = dayName,
                stickerColor = StickerColor.AZUL,
                restrictedPlates = emptyList()
            )



        }

    }
}
