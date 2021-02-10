package com.example.cafereviewapp

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class dessertActivity : AppCompatActivity()  {


    lateinit var listView_dessert : RecyclerView
    lateinit var fac_add : FloatingActionButton
    lateinit var search_dessert : SearchView

    //넣어둔 데이터
    var dessertList = arrayListOf<ListViewItemdessert>(
        ListViewItemdessert("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201019_286%2F1603076177636U1TVd_JPEG%2FCrwowIBGh1OvoK0ffT--aK6h.jpg",
            "토끼별", "아기자기한 분위기가 있는 카페", 4.0),
        ListViewItemdessert("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201010_144%2F1602317222846g0qOq_JPEG%2FNnqrjJ4s9iOKTyzyZIM7e7JZ.jpeg.jpg",
            "홀리몰리 베이글리", "베이글 종류가 많고 가격도 싸고 좋음", 5.0),
        ListViewItemdessert("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200506_150%2F1588729393633EHBj3_JPEG%2FNaDB80w9CNJK9_bs3sm2I5Ha.jpg",
            "에스로우 공릉점", "무난한곳 무료토스트바가 있는게 인상적이다.", 4.0)

    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        listView_dessert = findViewById(R.id.listView_dessert)
        fac_add = findViewById(R.id.fac_add)
        search_dessert = findViewById(R.id.search_dessert)

        val adapter = ListViewAdapterdessert(dessertList)


        //화면의 데이터 추가 버튼을 누른다면
        fac_add.setOnClickListener {
            //다이얼로그 창을 보여준다.
            val builder = AlertDialog.Builder(this)
            val dialogViewDessert = layoutInflater.inflate(R.layout.popup_dessert, null)
            builder.setTitle("카페 추가")
            builder.setView(dialogViewDessert)


            //팝업창 확인 버튼 클릭시
            var listener = DialogInterface.OnClickListener{ p0, _ ->
                var dialog = p0 as AlertDialog
                //val di_dessert_ok = dialogViewDessert.findViewById<Button>(R.id.btn_deOk)
                val di_dessert_name = dialogViewDessert.findViewById<EditText>(R.id.de_name)
                val di_dessert_url = dialogViewDessert.findViewById<EditText>(R.id.de_url)
                val di_dessert_review = dialogViewDessert.findViewById<EditText>(R.id.de_review)
                val di_dessert_star = dialogViewDessert.findViewById<RatingBar>(R.id.de_star)

                //팝업창 안의 레팅바
                di_dessert_star.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                    di_dessert_star.rating = rating
                }

                    val strDeName: String = di_dessert_name.text.toString()
                    val strDeUrl : String = di_dessert_url.text.toString()
                    val strDeReview : String = di_dessert_review.text.toString()
                    val strDeStar : Double = di_dessert_star.rating.toDouble()
                   //list에 추가
                    val dessert = ListViewItemdessert(strDeUrl, strDeName,strDeReview,strDeStar)
                    dessertList.add(dessert)
                    adapter.notifyDataSetChanged()

            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소",null)
            builder.show()

        }

        //클릭시 삭제기능
        adapter.setItemClickListener(object :ListViewAdapterdessert.OnItemClickListenr{
            override fun onClick(v: View, position: Int) {
                dessertList.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        })

        listView_dessert.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listView_dessert.setHasFixedSize(true)

        listView_dessert.adapter = adapter



    }


}