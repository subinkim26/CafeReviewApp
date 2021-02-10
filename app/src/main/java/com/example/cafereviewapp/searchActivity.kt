package com.example.cafereviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class searchActivity : AppCompatActivity() {


    lateinit var secondButton : ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        secondButton = findViewById(R.id.secondButton)


        secondButton.setOnClickListener {
            val intent = Intent(this, searchDetailActivity::class.java)
            startActivity(intent)

        }
    }
}