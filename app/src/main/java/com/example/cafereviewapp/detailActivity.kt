package com.example.cafereviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class detailActivity : AppCompatActivity() {

    lateinit var mapbutton : Button
    lateinit var listView_user : RecyclerView

    //유저 리스트
    var userList = arrayListOf<ListViewItemuser>(
            ListViewItemuser(R.drawable.user, "익명1","분위기가 따뜻하고 좋음",4.5),
            ListViewItemuser(R.drawable.user, "익명2","그냥 그럼",3.0)

    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        //각 버튼 연결
        mapbutton = findViewById(R.id.mapbutton)
        listView_user = findViewById(R.id.listView_user)

        //어뎁터와 데이터 리스트 연결
        val adapter = ListViewAdapteruser(userList)



        //상세주소 클릭
        mapbutton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }

        //리사이클러뷰와 레이아웃 어뎁터 연결
        listView_user.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listView_user.setHasFixedSize(true)

        listView_user.adapter = adapter



    }
}