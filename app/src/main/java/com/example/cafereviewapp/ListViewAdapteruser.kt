package com.example.cafereviewapp

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


//리사이클러뷰 스터디 어뎁터
class ListViewAdapteruser(val UserList:ArrayList<ListViewItemuser>) : RecyclerView.Adapter<ListViewAdapteruser.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapteruser.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_list_dessert, parent, false)
        return CustomViewHolder(view)
    }

    //스터디리스트 반환
    override fun getItemCount(): Int {
        return UserList.size
    }

    //스터디 리스트 바인드뷰홀더와 클릭이벤트 처리
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


       holder.apply {
           bind(UserList[position])
       }


    }


    //커스텀뷰홀더, 리사이클러뷰 스터디뷰 연결

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val icon = itemView.findViewById<ImageView>(R.id.dessert_img) //이미지
        val us_name = itemView.findViewById<TextView>(R.id.dessert_name) //이름
        val review = itemView.findViewById<TextView>(R.id.dessert_review) //리뷰
        val star = itemView.findViewById<RatingBar>(R.id.dessert_star) //별점점

        //스터디 연결
        val listUser = itemView.findViewById<LinearLayout>(R.id.custom)


        fun bind(ItemUser: ListViewItemuser){
            Glide.with(itemView.context).load(ItemUser.icon).placeholder(R.drawable.user).into(icon)
            us_name.text = ItemUser.us_name
            review.text = ItemUser.review
            star.rating = ItemUser.star.toFloat()


        }



    }



}