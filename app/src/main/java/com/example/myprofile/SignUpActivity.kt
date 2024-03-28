package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher


class SignUpActivity : AppCompatActivity() {

    private val name: EditText by lazy { findViewById(R.id.et_name) }
    private val id: EditText by lazy { findViewById(R.id.et_id) }
    private val password: EditText by lazy { findViewById(R.id.et_password) }
    private val register: Button by lazy { findViewById(R.id.btn_register) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        register.setOnClickListener {
            val checkName = name.text.toString()
            val checkId = id.text.toString()
            val checkPassword = password.text.toString()

            if (checkName.isEmpty() || checkId.isEmpty() || checkPassword.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", checkId)
                intent.putExtra("password", checkPassword)
                setResult(RESULT_OK, intent)
                finish()

            }
        }
    }

}