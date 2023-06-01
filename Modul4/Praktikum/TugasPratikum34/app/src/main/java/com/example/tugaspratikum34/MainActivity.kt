package com.example.tugaspratikum34

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.tugaspratikum34.adapter.UserAdapter
import com.example.tugaspratikum34.data.AppDatabase
import com.example.tugaspratikum34.data.entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.floating_btn)

        database = AppDatabase.getInstance(applicationContext)
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                // Membuat dialog view
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle(list[position].Nama_Lengkap)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{ dialog, which ->
                    if (which==0){
                        // coding ubah
                        val intent = Intent(this@MainActivity, EditActivity::class.java)
                        intent.putExtra("id", list[position].id)
                        startActivity(intent)
                    }
                    else if (which==1){
                        // coding hapus
                        database.userDao().delete(list[position])
                        getData()
                    }
                    else{
                        // coding batal
                        dialog.dismiss()
                    }
                })
                // Menampilkan dialog
                val dialogView = dialog.create()
                dialogView.show()

            }

        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext,VERTICAL))

        fab.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData(){
        list.clear()
        list.addAll(database.userDao().getAll())
        adapter.notifyDataSetChanged()
    }
}