package com.example.cafereviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var bookcafe : Button
    lateinit var catcafe : Button
    lateinit var cafe : Button
    lateinit var flowercafe : Button
    lateinit var studycafe : Button
    lateinit var gamecafe : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookcafe = findViewById(R.id.bookcafe)
        catcafe = findViewById(R.id.catcafe)
        cafe = findViewById(R.id.cafe)
        flowercafe = findViewById(R.id.flowercafe)
        studycafe = findViewById(R.id.studycafe)
        gamecafe = findViewById(R.id.gamecafe)


        studycafe.setOnClickListener {
            val intent = Intent(this, studyActivity::class.java)
            startActivity(intent)

        }



        cafe.setOnClickListener {
            val intent = Intent(this, dessertActivity::class.java)
            startActivity(intent)

        }





    }



}
