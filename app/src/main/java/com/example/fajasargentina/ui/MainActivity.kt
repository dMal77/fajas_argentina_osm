package com.example.fajasargentina.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fajasargentina.databinding.ActivityMainBinding
import org.osmdroid.config.Configuration
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Configuration.getInstance().userAgentValue = packageName
        mapView = binding.mapView
        mapView.setTileSource(TileSourceFactory.MAPNIK)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}