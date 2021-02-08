package com.example.cafereviewapp

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class dessertActivity : AppCompatActivity() {
    lateinit var listView_dessert : RecyclerView
    lateinit var fac_add : FloatingActionButton
    var count = 0

    //넣어둔 데이터
    var dessertList = arrayListOf<ListViewItemdessert>(
        ListViewItemdessert("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201019_286%2F1603076177636U1TVd_JPEG%2FCrwowIBGh1OvoK0ffT--aK6h.jpg",
            "토끼별", "맛있다", 4.5),
        ListViewItemdessert("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMThfMTQ5%2FMDAxNjAzMDMyOTI5NzEx.TCCp7iUF1reB1zwKaDyyLMmYY3113hJXhh8x-yCSzx8g.twhlNqGVWrnLGpTwMWaE4yLNpKBXnj-vjtxFX9zDh5Ig.JPEG.sh2dong%2FKakaoTalk_20201017_131925282_13_%25281%2529.jpg&type=sc960_832",
            "파리바게트", "그냥그럼", 3.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        listView_dessert = findViewById(R.id.listView_dessert)
        fac_add = findViewById(R.id.fac_add)

        val adapter = ListViewAdapterdessert(dessertList)

        //화면의 데이터 추가 버튼을 누른다면
        fac_add.setOnClickListener {
            //다이얼로그 창을 보여준다.
            val builder = AlertDialog.Builder(this)
            val dialogViewDessert = layoutInflater.inflate(R.layout.popup_dessert, null)
            builder.setTitle("카페 추가")
            builder.setView(dialogViewDessert)
            /*
            val di_dessert_ok = dialogViewDessert.findViewById<Button>(R.id.btn_deOk)
            val di_dessert_name = dialogViewDessert.findViewById<EditText>(R.id.de_name)
            val di_dessert_url = dialogViewDessert.findViewById<EditText>(R.id.de_url)
            val di_dessert_review = dialogViewDessert.findViewById<EditText>(R.id.de_review)
            val di_dessert_star = dialogViewDessert.findViewById<EditText>(R.id.de_star)
            */

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
                //다이얼로그에 있는 확인 버튼 클릭시
                //di_dessert_ok.setOnClickListener{
                    //입력한 데이터 가져오기

                    val strDeName: String = di_dessert_name.text.toString()
                    val strDeUrl : String = di_dessert_url.text.toString()
                    val strDeReview : String = di_dessert_review.text.toString()
                    val strDeStar : Double = di_dessert_star.rating.toDouble()
                    //LIST에 추가
                    val dessert = ListViewItemdessert(strDeUrl, strDeName,strDeReview,strDeStar)
                    dessertList.add(dessert)
                    adapter.notifyDataSetChanged()
                //}
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