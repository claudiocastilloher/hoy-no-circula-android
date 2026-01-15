package com.example.hoynocirculacdmx.domain.model

/**
 *  Representa el tipo de holograma del vehículo.
 *  Es un concepto del dominio (reclas reales del Hoy No circula).
 */

enum class Holograma {
    DOUBLE_ZERO, // 00
    ZERO, // 0
    ONE, // 1
    TWO; // 2

    /**
     *  Indica si el holograma permite circular
     *  sin restricciones entre semana
     */

    fun permiteCircularSiempre(): Boolean {
        return this == DOUBLE_ZERO || this == ZERO
    }
}