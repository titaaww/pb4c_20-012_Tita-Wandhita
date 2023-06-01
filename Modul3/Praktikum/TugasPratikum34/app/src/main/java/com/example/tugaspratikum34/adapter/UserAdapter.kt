package com.example.tugaspratikum34.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspratikum34.R
import com.example.tugaspratikum34.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog= dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var Nama_Lengkap: TextView
        var Email: TextView
        var Username: TextView
        var Password: TextView
        init {
            Nama_Lengkap = view.findViewById(R.id.full_name)
            Email= view.findViewById(R.id.email)
            Username = view.findViewById(R.id.username)
            Password= view.findViewById(R.id.password)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Nama_Lengkap.text = list[position].Nama_Lengkap
        holder.Email.text = list[position].Email
        holder.Username.text = list[position].Username
        holder.Password.text = list[position].Password
    }
}