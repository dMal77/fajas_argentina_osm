package com.example.fajasargentina.utils

import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polygon
import org.osmdroid.views.overlay.Marker
import com.example.fajasargentina.model.Provincia

object MapUtils {
    fun drawProvincia(mapView: MapView, provincia: Provincia) {
        val polygon = Polygon(mapView)
        polygon.points = provincia.coordinates.map { GeoPoint(it[1], it[0]) }
        polygon.fillColor = 0x2244FF44.toInt()
        polygon.strokeColor = 0xFF0000FF.toInt()
        mapView.overlays.add(polygon)
    }

    fun addMarker(mapView: MapView, point: GeoPoint, title: String) {
        val marker = Marker(mapView)
        marker.position = point
        marker.title = title
        mapView.overlays.add(marker)
    }
}