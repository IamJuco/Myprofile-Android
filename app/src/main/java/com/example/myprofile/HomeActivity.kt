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

    private val imageArea: ImageView by lazy { findViewById(R.id.iv_area) }
    private val exit: Button by lazy { findViewById(R.id.btn_exit) }
    private val id: TextView by lazy { findViewById(R.id.tv_id) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageArea.setImageResource(imageList.random())

        val data = intent.getStringExtra("loginId")
        id.text = data

        exit.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}