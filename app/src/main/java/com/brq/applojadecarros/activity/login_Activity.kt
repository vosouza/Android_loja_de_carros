package com.brq.applojadecarros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.brq.applojadecarros.R
import com.google.firebase.auth.FirebaseAuth

class login_Activity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var email : TextView
    private lateinit var senha : TextView

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        loadComponents()

        btnLogin.setOnClickListener {
            signIN(email.text.toString(),senha.text.toString())
        }

    }

    private fun signIN(email: String,senha: String){
        auth.signInWithEmailAndPassword(email,senha)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    //val user = auth.currentUser
                    logadoComSucesso()
                }else{
                    Toast.makeText(baseContext, "Falha ao Logar.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun logadoComSucesso() {
        Intent(this, Lista_carros_activity::class.java).apply {
            startActivity(this)
        }
    }

    private fun loadComponents() {
        email = findViewById (R.id.email)
        senha = findViewById (R.id.senha)
        btnLogin = findViewById (R.id.botao)
    }
}