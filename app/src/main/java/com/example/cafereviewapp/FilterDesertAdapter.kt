package com.example.cafereviewapp

/*
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//서치 검색 용
class FilterDesertAdapter (private val fileList: ArrayList<String>) :RecyclerView.Adapter<FilterDesertAdapter.SearchViewHolder>(), Filterable{

    private var filesDessert: ArrayList<String>? = fileList


    inner class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
       var str: TextView? = null

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterDesertAdapter.SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_list_dessert,parent, null)
        return SearchView(view)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return filesDessert?.size!!
    }

    override fun getFilter(): Filter? {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                filesDessert = if(charString.isEmpty()){
                    fileList
                }
                else{
                    val filteredDessert = ArrayList<String>()
                    if(fileList !=null){
                        for(name in fileList){
                            if(name.toLowerCase().contains(charString.toLowerCase())){
                                filteredDessert.add(name);
                            }
                        }
                    }
                    filteredDessert
                }
                val filterResultsDessert = FilterResults()
                filterResultsDessert.values = filesDessert
                return filterResultsDessert
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filesDessert = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }
    interface ItemClickListener{
        fun onClick(view : View, position: Int)
    }
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListner = itemClickListener
    }




}
*/
