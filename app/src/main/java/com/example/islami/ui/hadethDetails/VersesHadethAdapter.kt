package com.example.islami.ui.hadethDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class VersesHadethAdapter : RecyclerView.Adapter<VersesHadethAdapter.ViewHolder>() {
    var verses: List<String>? = null

    fun changeData(verses: List<String>) {
        this.verses = verses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura_verse, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.text = verses?.get(position)
    }

    override fun getItemCount(): Int = verses?.size ?: 0


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content_hadeth)
    }
}