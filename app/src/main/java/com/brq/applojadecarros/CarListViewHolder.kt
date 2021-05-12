package com.brq.applojadecarros

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var txtNome: TextView
    var srcImagem: ImageView
    var txtDescricaoTipo: TextView
    var txtDescricao: TextView
    var btnVerMais: Button

    init {
        txtNome = itemView.findViewById(R.id.item_card_name)
        srcImagem = itemView.findViewById(R.id.item_card_image)
        txtDescricao = itemView.findViewById(R.id.item_card_desc2)
        txtDescricaoTipo = itemView.findViewById(R.id.item_card_desc1)
        btnVerMais = itemView.findViewById(R.id.item_card_button_ver_mais)
    }

}
