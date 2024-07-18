package com.example.userapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.userapplication.models.LoginResponse
import com.example.userapplication.models.RegisterPassData
import com.example.userapplication.netwrok.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//
        val btnsignup = findViewById<AppCompatButton>(R.id.btnsignup)
        btnsignup.setOnClickListener {
            Toast.makeText(this, "button click", Toast.LENGTH_LONG).show()

            val registerData = RegisterPassData("Developer", "Developer89896@gmail.com", "123456")
            RetrofitClient.instance.register(registerData)
                .enqueue(object : retrofit2.Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>?,
                        response: Response<LoginResponse>?
                    ) {
                        if (response != null) {
                            if (response.isSuccessful) {
                                if (response.body().data != null) {
                                    startActivity(Intent(this@RegisterActivity, welcome::class.java)
                                    )
                                    Toast.makeText(this@RegisterActivity, "Register", Toast.LENGTH_LONG).show()
                                }
                            } else {

                            }
                        } else {

                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                    }


                })

        }
    }
}
