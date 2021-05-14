package com.brq.applojadecarros.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.brq.applojadecarros.R

class login_Activity : AppCompatActivity() {

    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadComponents()

        btnLogin.setOnClickListener {
            Intent(this, Lista_carros_activity::class.java).let {
                startActivity(it)
            }
        }

    }

    private fun loadComponents() {
        btnLogin = findViewById(R.id.login_button)
    }
}