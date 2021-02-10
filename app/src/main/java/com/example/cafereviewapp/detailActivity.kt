package com.example.cafereviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.ImageButton
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class detailActivity : AppCompatActivity() {



    lateinit var mapbutton : Button







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        mapbutton = findViewById(R.id.mapbutton)



        mapbutton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }






    }
}