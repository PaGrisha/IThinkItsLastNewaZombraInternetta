package com.example.ithinkitslastnewazombrainternetta.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ithinkitslastnewazombrainternetta.R

class MyLovelyAdapter(
    private val items: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<MyLovelyAdapter.ViewHolder>() {
    class ViewHolder(
        view: View,
        private val onItemClick: (String) -> Unit,
        private val items: List<String>
    ) : RecyclerView.ViewHolder(view) {
        val textView2: TextView =
            view.findViewById(R.id.textView2)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.carda_iteme,
            parent,
            false
        )
        return ViewHolder(view, onItemClick, items)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView2.text = items[position]
    }

    override fun getItemCount() = items.size
}
