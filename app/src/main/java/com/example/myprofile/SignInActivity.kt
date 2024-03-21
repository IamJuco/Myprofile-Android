package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val login = findViewById<Button>(R.id.btn_login)
        val register = findViewById<Button>(R.id.btn_register)
        val id = findViewById<EditText>(R.id.et_id)
        val password = findViewById<EditText>(R.id.et_password)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val loginId = result.data?.getStringExtra("id") ?: ""
                    val loginPassword = result.data?.getStringExtra("password") ?: ""

                    id.setText(loginId)
                    password.setText(loginPassword)

                }
            }

        login.setOnClickListener {
            val checkId = id.text.toString()
            val checkPassword = password.text.toString()

            if (checkId.isEmpty() || checkPassword.isEmpty()) {
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()

            }
            else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("loginId", checkId)
                startActivity(intent)

            }
        }

        register.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)

        }
    }

}