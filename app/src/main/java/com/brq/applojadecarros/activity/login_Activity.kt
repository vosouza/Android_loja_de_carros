package com.brq.applojadecarros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.brq.applojadecarros.R
import com.brq.applojadecarros.model.Pessoa

class login_Activity : AppCompatActivity() {

    lateinit var btnLogin: Button
    lateinit var email : TextView
    lateinit var senha : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadComponents()

        btnLogin.setOnClickListener () {
            var email = email (email = email.text.toString ())

            var senha = senha (senha = senha.text.toString ())

            if (email && senha) {
                startActivity ( Intent ( this , Lista_carros_activity :: class .java))
            }
            else {
                Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun senha(senha: String): Boolean {
        var s = Pessoa.senha()
        if(senha.equals(s)){

            return true

        }else{
            return false

        }

    }

    private fun email(email: String): Boolean {
        var e = Pessoa.email()
        if (email.equals(e)){

            return true
        }else{
            return false

        }
    }

    private fun loadComponents() {
        email = findViewById (R.id.email)
        senha = findViewById (R.id.senha)
        btnLogin = findViewById (R.id.botao)
    }
}