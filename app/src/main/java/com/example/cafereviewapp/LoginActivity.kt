package com.example.cafereviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class LoginActivity : AppCompatActivity() {

    //각변수선언
    lateinit var emailLoginBtn: Button
    lateinit var registrationBtn: Button
    lateinit var edit_email: EditText
    lateinit var edit_password: EditText

    val user: String by lazy {
        FirebaseAuth.getInstance().currentUser?.uid.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailLoginBtn = findViewById(R.id.emailLoginBtn)
        registrationBtn = findViewById(R.id.registrationBtn)
        edit_email = findViewById(R.id.edit_email)
        edit_password = findViewById(R.id.edit_password)

        registrationBtn.setOnClickListener {
            val intent = Intent(this, createUserActivity::class.java)
            startActivity(intent)

        }
        emailLoginBtn.setOnClickListener {
            loginEmail()
        }

    }

    fun loginEmail() {
        var email = edit_email.text.toString()
        var password = edit_password.text.toString()
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var currentUser = FirebaseAuth.getInstance().currentUser
                    val user = FirebaseAuth.getInstance().currentUser?.uid

                    if (currentUser != null) {

                        var doc = FirebaseFirestore.getInstance().collection("users")
                            .document(user.toString())

                        doc.get().addOnSuccessListener { document ->
                            if (document.data != null) {  //로그인 성공
                                startActivity(Intent(this, MainActivity::class.java))
                                this.finish()
                            }
                        }
                    }
                } else {
                    Toast.makeText(this, "가입정보가 확인되지 않습니다.\n가입하시기 위해서는 회원가입버튼을 눌러주세요.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }


}









