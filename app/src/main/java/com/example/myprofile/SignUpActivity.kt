package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<EditText>(R.id.et_name)
        val email = findViewById<EditText>(R.id.et_email)
        val password = findViewById<EditText>(R.id.et_password)
        val passwordCheck = findViewById<EditText>(R.id.et_passwordCheck)
        val register = findViewById<Button>(R.id.btn_register)

        register.setOnClickListener {
            val checkName = name.text.toString()
            val checkEmail = email.text.toString()
            val checkPassword = password.text.toString()
            val checkPasswrodCheck = passwordCheck.text.toString()

            // 비밀번호 유효성 검사 (영문, 숫자, 특수문자, 8 ~ 16자리 )
            val passwordPattern = Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,16}$", checkPassword)

            // 이메일 유효성 검사
            val emailPattern = Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", checkEmail)

            var isGoToJoin = true

            if (checkName.isEmpty() || checkEmail.isEmpty() || checkPassword.isEmpty() || checkPasswrodCheck.isEmpty()){
                Toast.makeText(this,"빈칸이 있습니다.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false

            } else if (!emailPattern){
                Toast.makeText(this, "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false

            } else if (checkPassword != checkPasswrodCheck){
                Toast.makeText(this, "비밀번호를 똑같이 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false

            } else if (!passwordPattern){
                Toast.makeText(this, "숫자 + 영문 + 특수문자 형식으로 8자이상 16자 이하로 조합해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (isGoToJoin){
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("email",checkEmail)
                intent.putExtra("password",checkPassword)
                setResult(RESULT_OK, intent)
                finish()
            }

        }
    }

}