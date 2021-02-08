package com.example.cafereviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var bookcafe :ImageButton
    lateinit var catcafe : ImageButton
    lateinit var cafe : ImageButton
    lateinit var flowercafe : ImageButton
    lateinit var studycafe : ImageButton
    lateinit var gamecafe : ImageButton
    lateinit var bannerbutton : ImageButton
    lateinit var button : Button
    lateinit var textView : TextView
    lateinit var textbanner : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookcafe = findViewById(R.id.bookcafe)
        catcafe = findViewById(R.id.catcafe)
        cafe = findViewById(R.id.cafe)
        flowercafe = findViewById(R.id.flowercafe)
        studycafe = findViewById(R.id.studycafe)
        gamecafe = findViewById(R.id.gamecafe)
        bannerbutton = findViewById(R.id.bannerbutton)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textbanner = findViewById(R.id.textbanner)


        studycafe.setOnClickListener {
            val intent = Intent(this, studyActivity::class.java)
            startActivity(intent)

        }


        cafe.setOnClickListener {
            val intent = Intent(this, dessertActivity::class.java)
            startActivity(intent)

        }

        bannerbutton.setOnClickListener {
            val intent = Intent(this, detailActivity::class.java)
            startActivity(intent)

        }



    }


}
