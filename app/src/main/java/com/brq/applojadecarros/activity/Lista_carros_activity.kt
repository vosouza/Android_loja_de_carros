package com.brq.applojadecarros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brq.applojadecarros.CarListAdapter
import com.brq.applojadecarros.R
import com.brq.applojadecarros.model.Car
import com.brq.applojadecarros.model.ItemClickListener

class Lista_carros_activity : AppCompatActivity(), ItemClickListener {

    var listaDeCarros: ArrayList<Car> = ArrayList<Car>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_carros)

        loadComponents()
        loadData()

        CarListAdapter(this, listaDeCarros,this).let{
            recyclerView.adapter = it
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() {

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

    }

    private fun loadComponents() {
        recyclerView = findViewById(R.id.rv_car_list)
    }

    override fun onClickItem(view: View?, index: Int) {
        startActivity(Intent(this, Detalhes_Activity::class.java))
    }

    override fun onLongCLickItem(view: View?, index: Int) {
        TODO("Not yet implemented")
    }

}
