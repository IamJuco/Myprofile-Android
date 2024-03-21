package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher


class SignUpActivity : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<EditText>(R.id.et_name)
        val id = findViewById<EditText>(R.id.et_id)
        val password = findViewById<EditText>(R.id.et_password)

        val register = findViewById<Button>(R.id.btn_register)

        register.setOnClickListener {
            val checkName = name.text.toString()
            val checkId = id.text.toString()
            val checkPassword = password.text.toString()

            if (checkName.isEmpty() || checkId.isEmpty() || checkPassword.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id",checkId)
                intent.putExtra("password",checkPassword)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}