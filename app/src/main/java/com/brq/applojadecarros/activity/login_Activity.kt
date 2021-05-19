package com.brq.applojadecarros.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.brq.applojadecarros.R
import com.google.firebase.auth.FirebaseAuth

class login_Activity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var email : TextView
    private lateinit var senha : TextView

    private lateinit var auth: FirebaseAuth
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        mp = MediaPlayer.create(this,R.raw.alarmedecarro)

        loadComponents()

        btnLogin.setOnClickListener {
            val email = email.text.toString()
            val senha = senha.text.toString()
            if(email.isNotEmpty() && email.isNotBlank() && senha.isNotEmpty() && senha.isNotBlank()) {
                signIN(email, senha)
            }else{
                msgErro()
            }
        }

    }

    private fun signIN(email: String,senha: String){
        auth.signInWithEmailAndPassword(email,senha)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    //val user = auth.currentUser
                    logadoComSucesso()
                }else{
                    msgErro()
                }
            }
    }

    private fun logadoComSucesso() {
        mp.start()
        //while(mp.isPlaying){}

        Intent(this, Lista_carros_activity::class.java).apply {
            startActivity(this)
        }
    }

    fun msgErro(){
        Toast.makeText(baseContext, "Falha ao Logar.",
            Toast.LENGTH_SHORT).show()
    }

    private fun loadComponents() {
        email = findViewById (R.id.email)
        senha = findViewById (R.id.senha)
        btnLogin = findViewById (R.id.botao)
    }
}