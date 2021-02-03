package com.example.cafereviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class createUserActivity : AppCompatActivity() {

    lateinit var registrationBtnResult : Button
    lateinit var email_result : EditText
    lateinit var password_result : EditText

    val user: String by lazy {
        FirebaseAuth.getInstance().currentUser?.uid.toString()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)



        registrationBtnResult = findViewById(R.id.registrationBtnResult)
        email_result = findViewById(R.id.email_result)
        password_result = findViewById(R.id.password_result)

        registrationBtnResult.setOnClickListener {
            createEmailId()
        }

    }

    fun createEmailId() {
        var email = email_result.text.toString()
        var password = password_result.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // 계정생성과정으로 넘기는 부분
                    Toast.makeText(this,"계정생성",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"생성실패",Toast.LENGTH_SHORT).show()
                }
            }
    }
}