package com.example.modul2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var mainAdapter : MainAdapter?=null
    private var recyclerView : RecyclerView?=null
    private var chatlist = mutableListOf<data>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chatlist = ArrayList()

        recyclerView= findViewById<View>(R.id.r_item) as RecyclerView
        mainAdapter = MainAdapter(this@MainActivity,chatlist)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager =layoutManager
        recyclerView!!.adapter = mainAdapter
        preparechatlist()

    }

    private fun preparechatlist() {
        var chat = data("Lontong Balap", "Surabaya",R.drawable.lontong)
        chatlist.add(chat)
        chat = data("Bakso Malang", "Malang",R.drawable.bakso)
        chatlist.add(chat)
        chat = data("Mie Aceh", "Aceh",R.drawable.mie)
        chatlist.add(chat)
        chat = data("Kerak Telor", "DKI Jakarta",R.drawable.kerak)
        chatlist.add(chat)
        chat = data("Lontong Balap", "Surabaya",R.drawable.lontong)
        chatlist.add(chat)
        chat = data("Bakso Malang", "Malang",R.drawable.bakso)
        chatlist.add(chat)
        chat = data("Mie Aceh", "Aceh",R.drawable.mie)
        chatlist.add(chat)
        chat = data("Kerak Telor", "DKI Jakarta",R.drawable.kerak)
        chatlist.add(chat)
        chat = data("Lontong Balap", "Surabaya",R.drawable.lontong)
        chatlist.add(chat)
        chat = data("Bakso Malang", "Malang",R.drawable.bakso)
        chatlist.add(chat)
        chat = data("Mie Aceh", "Aceh",R.drawable.mie)
        chatlist.add(chat)
        chat = data("Kerak Telor", "DKI Jakarta",R.drawable.kerak)
        chatlist.add(chat)



        mainAdapter!!.notifyDataSetChanged()
    }
}