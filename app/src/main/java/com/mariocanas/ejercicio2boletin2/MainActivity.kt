package com.mariocanas.ejercicio2boletin2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mariocanas.ejercicio2boletin2.databinding.ActivityMainBinding
import com.mariocanas.ejercicio2boletin2.model.Ciudad

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ciudades = listOf(
            Ciudad("Madrid", "https://picsum.photos/200/300?random=1", "40.416775", "-3.703790"),
            Ciudad("Barcelona", "https://picsum.photos/200/300?random=2", "41.385064", "2.173403"),
            Ciudad("Valencia", "https://picsum.photos/200/300?random=3", "39.469907", "-0.376288"),
            Ciudad("Sevilla", "https://picsum.photos/200/300?random=4", "37.389092", "-5.984459"),
            Ciudad("Zaragoza", "https://picsum.photos/200/300?random=5", "41.648822", "-0.889085"),
            Ciudad("Málaga", "https://picsum.photos/200/300?random=6", "36.721261", "-4.421265"),
            Ciudad("Murcia", "https://picsum.photos/200/300?random=7", "37.983810", "-1.130536"),
            Ciudad("Palma de Mallorca", "https://picsum.photos/200/300?random=8", "39.569578", "2.650187"),
            Ciudad("Bilbao", "https://picsum.photos/200/300?random=9", "43.263013", "-2.935013"),
            Ciudad("Granada", "https://picsum.photos/200/300?random=10", "37.177336", "-3.598557")
        )

        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)

            recyclerView.adapter = CiudadesAdapter(ciudades, this@MainActivity)
        }
    }
}
