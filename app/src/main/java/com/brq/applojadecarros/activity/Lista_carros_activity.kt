package com.brq.applojadecarros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brq.applojadecarros.CarListAdapter
import com.brq.applojadecarros.R
import com.brq.applojadecarros.model.Car
import com.brq.applojadecarros.model.ItemClickListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Lista_carros_activity : AppCompatActivity(), ItemClickListener {

    private var listaDeCarros: ArrayList<Car> = ArrayList()
    private lateinit var recyclerView: RecyclerView


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
        val db = Firebase.firestore
        db.collection("Carros")
            .get()
            .addOnSuccessListener {
                for(document in it ){
                    Log.d("teste",document.get("Tipo").toString())

                    val carro = Car(
                        document.get("NomeCarro").toString(),
                        document.get("ImagemURL").toString(),
                        document.get("Tipo").toString(),
                        document.get("Descricao").toString(),
                        document.get("Descricao2").toString()
                    )
                    listaDeCarros.add(carro)
                }
                recyclerView.adapter?.notifyDataSetChanged()
                Log.d("teste",listaDeCarros.size.toString())
            }
            .addOnFailureListener{
                Log.d("FireBase", "DocumentSnapshot failure with ID: $it")
            }
        Car.listaDeCarros = this.listaDeCarros
    }

    private fun loadComponents() {
        recyclerView = findViewById(R.id.rv_car_list)
    }

    override fun onClickItem(view: View?, index: Int) {
        Intent(this, Detalhes_Activity::class.java).apply {
            putExtra("CarId",index)
            startActivity(this)
        }
    }

    override fun onLongCLickItem(view: View?, index: Int) {
        TODO("Not yet implemented")
    }

}
