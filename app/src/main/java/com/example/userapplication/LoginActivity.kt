package com.example.userapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.userapplication.models.LoginPassData
import com.example.userapplication.models.LoginResponse
import com.example.userapplication.netwrok.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonlogin = findViewById<AppCompatButton>(R.id.buttonlogin)
        buttonlogin.setOnClickListener {
            Toast.makeText(this, "button click", Toast.LENGTH_LONG).show()

            //Button Click par aa code Mukva no che
            var loginData = LoginPassData("Developer", "Developer5@gmail.com", "123456")
            RetrofitClient.instance.login(loginData)
                .enqueue(/* callback = */ object : retrofit2.Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>?,
                        response: Response<LoginResponse>?
                    ) {
                        if (response != null) {
                            if (response.isSuccessful) {
                                if (response.body().data != null) {
                                    Toast.makeText(this@LoginActivity, "Login", Toast.LENGTH_LONG).show()
                                    startActivity(Intent(this@LoginActivity, welcome::class.java))
                                }
                            } else {

                            }
                        } else {

                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })

        }
    }
}




