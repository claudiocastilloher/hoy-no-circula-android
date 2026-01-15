package com.example.hoynocirculacdmx.domain.rules

import com.example.hoynocirculacdmx.domain.model.StickerColor

/**
 *  Reglas puras del dominio para determinar el engomado
 * a partir del último dígito de la placa.
 *
 *  No depende de fechas, Android ni estado externo.
 *
 */


object StickerRules {

    fun fromPlateLastDigit(lastDigit: Int): StickerColor {
        return when (lastDigit) {
            5,6 -> StickerColor.AMARILLO
            7,8 -> StickerColor.ROSA
            3,4 -> StickerColor.ROJO
            1,2 -> StickerColor.VERDE
            9,0 -> StickerColor.AZUL
            else -> throw IllegalArgumentException("Dígito de placa inválido")
        }

    }

}