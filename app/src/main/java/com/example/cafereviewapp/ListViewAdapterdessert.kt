package com.example.cafereviewapp


import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class ListViewAdapterdessert(val DessertList:ArrayList<ListViewItemdessert>) : RecyclerView.Adapter<ListViewAdapterdessert.CustomViewHolder>() {


    /*
    interface OnItemClickListener{
        fun onItemClick(v:View, data: ListViewItemdessert, pos: Int)
    }
    private var listener : OnItemClickListener?=null
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapterdessert.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_list_dessert, parent, false)
        return CustomViewHolder(view)
    }


        override fun getItemCount(): Int {
            return DessertList.size
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

            /*
            Glide.with(context).load(DessertList[position].icon).into(holder.icon)
            holder.de_name.text = DessertList.get(position).de_name
            holder.review.text = DessertList.get(position).review
            holder.star.text = DessertList.get(position).star

             */
            //holder.bind(DessertList[position])
           holder.apply {
               bind(DessertList[position])

           }
            holder.itemView.setOnClickListener {
                itemClickListener.onClick(it,position)
            }


        }
    interface OnItemClickListenr{
        fun onClick(v : View, position: Int)
    }
    private lateinit var itemClickListener : OnItemClickListenr

    fun setItemClickListener(itemClickListener: OnItemClickListenr){
        this.itemClickListener = itemClickListener
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            val icon = itemView.findViewById<ImageView>(R.id.dessert_img) //이미지
            val de_name = itemView.findViewById<TextView>(R.id.dessert_name) //이름
            val review = itemView.findViewById<TextView>(R.id.dessert_review) //리뷰
            val star = itemView.findViewById<RatingBar>(R.id.dessert_star) //별점점

            val listDessert = itemView.findViewById<LinearLayout>(R.id.dessert_custom)


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







