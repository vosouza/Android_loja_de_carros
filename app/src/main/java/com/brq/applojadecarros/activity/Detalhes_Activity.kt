package com.brq.applojadecarros.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.brq.applojadecarros.R
import com.brq.applojadecarros.model.Car
import com.brq.applojadecarros.model.ItemClickListener
import com.bumptech.glide.Glide

class Detalhes_Activity : AppCompatActivity(), ItemClickListener{


    lateinit var txtNome: TextView
    lateinit var imgCarro: ImageView
    lateinit var txtDescricao1: TextView
    lateinit var txtDescricao2: TextView
    lateinit var txtPreco: TextView
    lateinit var btnOrcamento: Button

    private lateinit var carro : Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        loadComponents()

        val listaCarros = Car.listaDeCarros
        val intent = intent
        val carId = intent.getIntExtra("CarId", -1)

        if(carId == -1){
            Toast.makeText(this,"Erro ao localizar o carro", Toast.LENGTH_LONG).show()
        }else{
            carro = listaCarros[carId]
            loadContent()
        }

    }

    private fun loadContent() {
        txtNome.text = carro.nomeCarro
        Glide.with(this).load(carro.Image).into(imgCarro)
        txtDescricao1.text = resources.getString(R.string.carro1_desc1)
        txtDescricao2.text = carro.descricao
        txtPreco.text = ""
    }

    fun loadComponents(){
        txtNome = findViewById<TextView>(R.id.txt_nome_veiculo)
        imgCarro = findViewById<ImageView>(R.id.imagem_car)
        txtDescricao1 = findViewById<TextView>(R.id.txt_descricao1)
        txtDescricao2 = findViewById<TextView>(R.id.txt_descricao2)
        txtPreco = findViewById<TextView>(R.id.txt_Preco)
        btnOrcamento = findViewById<Button>(R.id.btn_Pedir_Orcamento)
    }

    override fun onClickItem(view: View?, index: Int) {
    }

    override fun onLongCLickItem(view: View?, index: Int) {
        //nao usado
    }
}