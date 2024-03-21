package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignUpActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_password = findViewById<EditText>(R.id.et_password)

        val btn_register = findViewById<Button>(R.id.btn_register)

        btn_register.setOnClickListener {
            val checkName = et_name.text.toString()
            val checkId = et_id.text.toString()
            val checkPassword = et_password.text.toString()

            if (checkName.isEmpty() || checkId.isEmpty() || checkPassword.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()


            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id",checkId)
                intent.putExtra("password",checkPassword)
                setResult(RESULT_OK, intent)
                startActivity(intent)
                finish()

            }
        }

    }
}