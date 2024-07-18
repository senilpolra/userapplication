package com.example.userapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class welcome : AppCompatActivity() {

    var uservalu: Int? = null
    var isper: Boolean? = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)




            val btnloginwelcome = findViewById<AppCompatButton>(R.id.btnloginwelcome)

            btnloginwelcome.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))


            }

            val register = findViewById<AppCompatButton>(R.id.register)

            register.setOnClickListener {
                startActivity(Intent(this, RegisterActivity::class.java))
            }


        }


    }


