package com.example.recycleviewpartie1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class myAdapter(private val myDataset: ArrayList<String>, private val listener: OnItemClickListener) : RecyclerView.Adapter<myAdapter.ViewHolder>()
{
   inner class ViewHolder(val itemview: View): RecyclerView.ViewHolder(itemview),View.OnClickListener {
       val vText = itemView.findViewById(R.id.word) as TextView


       init {
           itemView.setOnClickListener(this)
       }

       override fun onClick(v: View?) {
           val position = adapterPosition
           if (position != RecyclerView.NO_POSITION) {
               listener.onItemClick(position)
           }
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.liste_items,
            parent,false)
        return ViewHolder(vh)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current = myDataset[position]
        holder.vText.text = current.toString();

    }

    override fun getItemCount(): Int {
        return myDataset.size

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}