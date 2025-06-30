package com.example.fajasargentina.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fajasargentina.databinding.ActivityHistoryBinding
import com.example.fajasargentina.db.LocationHistoryDao
import com.example.fajasargentina.model.LocationHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private lateinit var dao: LocationHistoryDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = (application as FajasApplication).database.historyDao()
        
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadHistory()
    }

    private fun loadHistory() {
        GlobalScope.launch(Dispatchers.IO) {
            val history = dao.getAllByDate()
            runOnUiThread {
                binding.recyclerView.adapter = HistoryAdapter(history)
            }
        }
    }
}