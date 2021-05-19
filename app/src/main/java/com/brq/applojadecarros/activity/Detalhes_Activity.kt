package com.brq.applojadecarros.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.brq.applojadecarros.R
import com.brq.applojadecarros.model.Car
import com.bumptech.glide.Glide


class Detalhes_Activity : AppCompatActivity(){


    lateinit var txtNome: TextView
    lateinit var imgCarro: ImageView
    lateinit var txtDescricao1: TextView
    lateinit var txtDescricao2: TextView
    lateinit var btnOrcamento: Button
    lateinit var btnVoltar: Button

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
        txtDescricao1.text = carro.descricao2
        txtDescricao2.text = carro.descricao


    }

    fun loadComponents(){
        txtNome = findViewById<TextView>(R.id.txt_nome_veiculo)
        imgCarro = findViewById<ImageView>(R.id.imagem_car)
        txtDescricao1 = findViewById<TextView>(R.id.txt_descricao1)
        txtDescricao2 = findViewById<TextView>(R.id.txt_descricao2)
        btnOrcamento = findViewById<Button>(R.id.btn_Pedir_Orcamento)
        btnVoltar = findViewById(R.id.btn_voltar)

        btnVoltar.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    Lista_carros_activity::class.java
                )
            )
            finishAffinity()
        }

        btnOrcamento.setOnClickListener {
            var texto: String = getString(R.string.corpo_email)
            texto += "\nCarro: ${carro.nomeCarro}"

            val intent = Intent().apply {
                action = Intent.CATEGORY_APP_EMAIL
                putExtra(Intent.EXTRA_TEXT,texto)
                type = "text/plain"
            }
            try{
                startActivity(intent)
            }catch (e: ActivityNotFoundException){

            }
        }
    }
}