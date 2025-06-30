package com.example.fajasargentina.utils

import android.content.Context
import com.google.gson.Gson
import com.example.fajasargentina.model.Provincia
import org.osmdroid.util.GeoPoint

object GeoUtils {
    // Conversión de coordenadas
    fun decimalToDMS(coordinate: Double, isLatitude: Boolean): String {
        val direction = if (isLatitude) 
            if (coordinate >= 0) "N" else "S" 
        else 
            if (coordinate >= 0) "E" else "O"
        
        val absCoord = Math.abs(coordinate)
        val degrees = absCoord.toInt()
        val minutes = ((absCoord - degrees) * 60).toInt()
        val seconds = ((absCoord - degrees - minutes / 60.0) * 3600)
        
        return String.format("%d° %d' %.2f\" %s", degrees, minutes, seconds, direction)
    }

    // Detección de provincia (simplificado)
    fun detectProvincia(context: Context, point: GeoPoint): String? {
        val provincias = loadProvincias(context)
        return provincias.firstOrNull { it.contains(point) }?.nombre
    }

    private fun loadProvincias(context: Context): List<Provincia> {
        val json = context.assets.open("provincias_arg.geojson")
            .bufferedReader().use { it.readText() }
        return Gson().fromJson(json, Array<Provincia>::class.java).toList()
    }
}