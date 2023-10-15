package com.mariocanas.ejercicio2boletin2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mariocanas.ejercicio2boletin2.model.Ciudad
import com.mariocanas.ejercicio2boletin2.databinding.ViewCiudadBinding // Cambia aquí al nombre correcto

class CiudadesAdapter(val ciudades: List<Ciudad>, val context: Context) :
    RecyclerView.Adapter<CiudadesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewCiudadBinding.bind(view) // Cambia aquí al nombre correcto

        fun bind(ciudad: Ciudad) {
            with(binding) {
                nombre.text = ciudad.nombreCiudad
                Glide.with(root.context).load(ciudad.urlImagenCiudad).into(imagen)
               //-----------------------------------------------
                itemView.setOnClickListener {
                    val uri = "geo:${ciudad.latitud},${ciudad.altitud}?q=${ciudad.latitud},${ciudad.altitud}(${ciudad.nombreCiudad})"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                    intent.setPackage("com.google.android.apps.maps")
                    itemView.context.startActivity(intent)
                }
                //-----------------------------------------------
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_ciudad, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = ciudades.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ciudades[position])
    }
}
