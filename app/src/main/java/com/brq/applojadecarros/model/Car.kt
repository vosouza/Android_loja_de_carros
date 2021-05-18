package com.brq.applojadecarros.model

import android.net.Uri

class Car(
    var nomeCarro: String,
    var Image: String,
    var tipoCarro: String,
    var descricao:String
)
{
    companion object {
        var listaDeCarros: ArrayList<Car> = ArrayList<Car>()
    }

}