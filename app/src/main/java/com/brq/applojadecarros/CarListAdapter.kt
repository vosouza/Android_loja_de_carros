package com.brq.applojadecarros

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.brq.applojadecarros.model.Car

class CarListAdapter(
    val context: Context,
    val listaDeCarros: ArrayList<Car>
): RecyclerView.Adapter<CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_list, parent,false)
        return  CarListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        listaDeCarros[position].also {
            holder.txtNome.text = it.nomeCarro
            holder.txtDescricaoTipo.text = it.tipoCarro
            holder.txtDescricao.text = it.descricao
            holder.srcImagem.setImageResource(it.Image)
        }
    }

    override fun getItemCount(): Int {
        return listaDeCarros.size
    }
}