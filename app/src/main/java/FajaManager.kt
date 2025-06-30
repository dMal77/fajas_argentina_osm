package com.example.fajasargentina.utils

object FajaManager {
    private val fajas = listOf(
        Faja(1, -73.5, -70.5),
        Faja(2, -70.5, -67.5),
        Faja(3, -67.5, -64.5),
        Faja(4, -64.5, -61.5),
        Faja(5, -61.5, -58.5),
        Faja(6, -58.5, -55.5),
        Faja(7, -55.5, -52.5)
    )

    fun determinarFaja(longitud: Double): Int {
        return fajas.firstOrNull { it.contiene(longitud) }?.numero ?: -1
    }
}

data class Faja(val numero: Int, val oeste: Double, val este: Double) {
    fun contiene(longitud: Double): Boolean {
        return longitud in oeste..este
    }
}