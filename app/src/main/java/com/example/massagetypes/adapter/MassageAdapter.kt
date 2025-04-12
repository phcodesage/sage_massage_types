package com.example.massagetypes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.massagetypes.R
import com.example.massagetypes.model.Massage

class MassageAdapter(
    private val massages: List<Massage>,
    private val onItemClick: (Massage) -> Unit
) : RecyclerView.Adapter<MassageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_massage, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val massage = massages[position]
        holder.bind(massage)
        holder.itemView.setOnClickListener { onItemClick(massage) }
    }

    override fun getItemCount() = massages.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.massage_image)
        private val name: TextView = itemView.findViewById(R.id.massage_name)

        fun bind(massage: Massage) {
            image.setImageResource(massage.imageResource)
            name.text = massage.name
        }
    }
}