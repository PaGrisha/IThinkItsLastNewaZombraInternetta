package com.example.ithinkitslastnewazombrainternetta.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ithinkitslastnewazombrainternetta.R

class MyLovelyAdapter(/*private val dataset: List<PlantFromInternet>*/) :
    RecyclerView.Adapter<MyLovelyAdapter.ViewHolder>() {
    private val items = mutableListOf<String>()


    fun submitList(names: List<String>,  /*onItemClick: (String) -> Unit*/) {

        // items.clear()
        items.addAll(names)
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView2)
        init {
            // Вешаем клик на весь элемент списка
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    //onItemClick(items[position])
                }
            }
        }
        //val textView2: TextView = view.findViewById(R.id.textView3)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.carda_iteme, parent, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = items[position]
        //viewHolder.textView2.text =items[position].toughness
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items.size

}