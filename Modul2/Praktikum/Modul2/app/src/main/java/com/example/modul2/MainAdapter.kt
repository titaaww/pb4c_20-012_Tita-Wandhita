package com.example.modul2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul2.MainActivity
import com.example.modul2.R

class MainAdapter(
    private val getActivity: MainActivity,
    private val chatlist : List<data>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama : TextView =itemView.findViewById(R.id.nama)
        val pesan : TextView =itemView.findViewById(R.id.detail)
        val gambar : ImageView =itemView.findViewById(R.id.gambar)
        val cardView : CardView =itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text= chatlist[position].name
        holder.pesan.text = chatlist[position].detail
        holder.gambar.setImageResource(chatlist[position].photo)
        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity,chatlist[position].name, Toast.LENGTH_LONG).show()
        }
    }
}