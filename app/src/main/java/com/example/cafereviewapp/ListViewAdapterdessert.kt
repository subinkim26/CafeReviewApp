package com.example.cafereviewapp


import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


//디저트 리스트 어뎁터 클래스
class ListViewAdapterdessert(val DessertList:ArrayList<ListViewItemdessert>) : RecyclerView.Adapter<ListViewAdapterdessert.CustomViewHolder>() {



    //레이아웃연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapterdessert.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_list_dessert, parent, false)
        return CustomViewHolder(view)
    }


        //디저트 목록 크기 반환
        override fun getItemCount(): Int {
            return DessertList.size
        }

    //클릭과 데이터 연결
        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

           holder.apply {
               bind(DessertList[position])

           }
            holder.itemView.setOnClickListener {
                itemClickListener.onClick(it,position)
            }


        }
    //클릭 변수
    interface OnItemClickListenr{
        fun onClick(v : View, position: Int)
    }
    private lateinit var itemClickListener : OnItemClickListenr

    fun setItemClickListener(itemClickListener: OnItemClickListenr){
        this.itemClickListener = itemClickListener
    }


    //커스텀 리사이클러뷰홀더
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            val icon = itemView.findViewById<ImageView>(R.id.dessert_img) //이미지
            val de_name = itemView.findViewById<TextView>(R.id.dessert_name) //이름
            val review = itemView.findViewById<TextView>(R.id.dessert_review) //리뷰
            val star = itemView.findViewById<RatingBar>(R.id.dessert_star) //별점점

        //디저트 레이아웃과 연결
            val listDessert = itemView.findViewById<LinearLayout>(R.id.custom)


            fun bind(ItemDessert: ListViewItemdessert){
                Glide.with(itemView.context).load(ItemDessert.icon).placeholder(R.drawable.dessert).into(icon)
                de_name.text = ItemDessert.de_name
                review.text = ItemDessert.review
                star.rating = ItemDessert.star.toFloat()
                //listDessert.setOnClickListener(onClickListener)

            }

            //클릭이벤트
            fun bindle(onClickListener: View.OnClickListener) {
                listDessert.setOnClickListener(onClickListener)
            }


        }



}








