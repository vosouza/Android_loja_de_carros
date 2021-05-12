package com.brq.applojadecarros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brq.applojadecarros.model.Car

class Lista_carros_activity : AppCompatActivity() {

    var listaDeCarros: ArrayList<Car> = ArrayList<Car>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_carros)

        loadComponents()
        loadData()

        CarListAdapter(this, listaDeCarros).let{
            recyclerView.adapter = it
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() {

        Car("Fiat Uno", R.mipmap.card_image_exemple, "Carro de passeio", "Texto grande").apply {
            listaDeCarros.add(this)
        }
    }

    private fun loadComponents() {
        recyclerView = findViewById(R.id.rv_car_list)
    }

}
