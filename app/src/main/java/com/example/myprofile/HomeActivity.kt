package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private val imageList = listOf(
        R.drawable.seonghyun1,
        R.drawable.seonghyun2,
        R.drawable.seonghyun3,
        R.drawable.seonghyun4,
        R.drawable.seonghyun5,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var imageArea = findViewById<ImageView>(R.id.iv_area)
        val exit = findViewById<Button>(R.id.btn_exit)
        val email = findViewById<TextView>(R.id.tv_email)

        imageArea.setImageResource(imageList.random())

        val data = intent.getStringExtra("loginEmail")
        email.text = data

        exit.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}