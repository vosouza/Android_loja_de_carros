package com.brq.applojadecarros.model

import android.widget.ImageView
import com.brq.applojadecarros.R

class Car(
    var nomeCarro: String,
    var Image: Int,
    var tipoCarro: String,
    var descricao:String
)
{
    companion object {
        fun getCarList(): ArrayList<Car> {
            val listaDeCarros = ArrayList<Car>()
            Car("Fiat Uno", R.drawable.uno, "Carro de passeio", "Texto grande").apply {
                listaDeCarros.add(this)
            }
            Car("Volkswagen Gol", R.drawable.gol, "Carro de corrida", "Texto grande mesmo").apply {
                listaDeCarros.add(this)
            }
            Car("Fiat Argo", R.drawable.argo, "Carro de passeio", "Texto grande").apply {
                listaDeCarros.add(this)
            }
            Car("Toyota Corolla", R.drawable.corolla, "Carro de passeio", "Texto grande").apply {
                listaDeCarros.add(this)
            }
            Car("Hyundai HB20", R.drawable.hb20, "Carro de passeio", "Texto grande").apply {
                listaDeCarros.add(this)
            }
            Car("Chevrolet Prisma", R.drawable.prisma, "Carro de passeio", "Texto grande").apply {
                listaDeCarros.add(this)
            }
            Car("Jeep Renegade", R.drawable.renegade, "Carro de passeio", "Texto grande").apply {
                listaDeCarros.add(this)
            }

            return listaDeCarros
        }
    }
}