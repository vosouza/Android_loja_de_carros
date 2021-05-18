package com.brq.applojadecarros

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.brq.applojadecarros.model.Car
import com.brq.applojadecarros.model.ItemClickListener
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.io.File

class CarListAdapter(
    val context: Context,
    private val listaDeCarros: ArrayList<Car>,
    private val onClick: ItemClickListener? = null
): RecyclerView.Adapter<CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_list, parent,false)
        return  CarListViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        listaDeCarros[position].also {
            holder.txtNome.text = it.nomeCarro
            holder.txtDescricaoTipo.text = it.tipoCarro
            holder.txtDescricao.text = it.descricao

            //holder.srcImagem.setImageURI(it.Image)
            Glide.with(context).load(it.Image).into(holder.srcImagem)
        }
    }

    override fun getItemCount(): Int {
        return listaDeCarros.size
    }
}