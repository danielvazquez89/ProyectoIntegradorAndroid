package com.example.actividad3a

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.actividad3a.data.models.GenerosResponse

class HomeAdapter(private val mDataSet: ArrayList<GenerosResponse.GenerosResponseItem>, var onClick: (GenerosResponse.GenerosResponseItem) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.genre_list, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataSet.get(position)
        data.let { holder.bindItems(it) }
        holder.itemView.setOnClickListener {
            onClick(data)
            Log.i("pepa", "entras?")
            //if (data)
              //  holder.mytexto.text = "\uFEFF\uD83D\uDCA5\uFEFF"
            //else
              //  holder.mytexto.text = "\uFEFF\uD83D\uDEA9\uFEFF "

        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        val mytexto = v.findViewById<TextView>(R.id.miTextoGenero)
        val miFoto = v.findViewById<ImageView>(R.id.imagenGenero)
        fun bindItems(data: GenerosResponse.GenerosResponseItem) {
            //mytexto.text = data
            mytexto.text = data.tipoGenero
            Glide.with(miFoto.context).load(data.urlImagen).into(miFoto)
        }
    }
}