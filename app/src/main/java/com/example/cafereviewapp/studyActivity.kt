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

class studyActivity : AppCompatActivity()  {


    lateinit var listView_study : RecyclerView
    lateinit var fac_add_study : FloatingActionButton
    lateinit var search_study : SearchView
    var count = 0

    //넣어둔 데이터
    var studyList = arrayListOf<ListViewItemstudy>(
        ListViewItemstudy("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201007_169%2F1602069632418ap0pD_JPEG%2F556A8443.jpg",
            "토즈스터디센터", "시설이 깔끔하고 조용함", 4.0),
        ListViewItemstudy("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210111_293%2F1610331793470RYzQz_JPEG%2FN7iFyAD2Q3SdrhGKTWrfl_w7.jpg",
            "작심스터디카페", "화장실이 깨끗한편 개인방은 적음", 3.0),
        ListViewItemstudy("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20180814_168%2F1534229004912JorKe_JPEG%2Fr5h-EEtKVX94eVcK3f-xBtfT.jpg",
                            "비에이블스터디카페","분위기가 따뜻하고 좋음",5.0)
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)

        //각 버튼 연결
        listView_study = findViewById(R.id.listView_study)
        fac_add_study = findViewById(R.id.fac_add_study)
        search_study = findViewById(R.id.search_study)

        //어뎁터와 데이터 리스트 연결
        val adapter = ListViewAdapterstudy(studyList)

        //화면의 데이터 추가 버튼을 누른다면
        fac_add_study.setOnClickListener {
            //다이얼로그 창을 보여준다.
            val builder = AlertDialog.Builder(this)
            val dialogViewStudy = layoutInflater.inflate(R.layout.popup_dessert, null)
            builder.setTitle("카페 추가")
            builder.setView(dialogViewStudy)

            //팝업창 확인 버튼 클릭시
            var listener = DialogInterface.OnClickListener{ p0, _ ->
                var dialog = p0 as AlertDialog
                val di_study_name = dialogViewStudy.findViewById<EditText>(R.id.de_name)
                val di_study_url = dialogViewStudy.findViewById<EditText>(R.id.de_url)
                val di_study_review = dialogViewStudy.findViewById<EditText>(R.id.de_review)
                val di_study_star = dialogViewStudy.findViewById<RatingBar>(R.id.de_star)

                //팝업창 안의 레팅바
                di_study_star.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                    di_study_star.rating = rating
                }

                val strDeName: String = di_study_name.text.toString()
                val strDeUrl : String = di_study_url.text.toString()
                val strDeReview : String = di_study_review.text.toString()
                val strDeStar : Double = di_study_star.rating.toDouble()
                //LIST에 추가
                val study = ListViewItemstudy(strDeUrl, strDeName,strDeReview,strDeStar)
                studyList.add(study)
                adapter.notifyDataSetChanged()

            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소",null)
            builder.show()

        }

        //클릭시 삭제기능
        adapter.setItemClickListener(object :ListViewAdapterstudy.OnItemClickListenr{
            override fun onClick(v: View, position: Int) {
                studyList.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        })

        //리스트뷰와 업뎁터 레이아웃들 연결
        listView_study.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listView_study.setHasFixedSize(true)

        listView_study.adapter = adapter



    }


}