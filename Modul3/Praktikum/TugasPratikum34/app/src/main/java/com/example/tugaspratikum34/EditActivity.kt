package com.example.tugaspratikum34

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugaspratikum34.data.AppDatabase
import com.example.tugaspratikum34.data.entity.User

class EditActivity : AppCompatActivity() {

    private lateinit var Nama_Lengkap: EditText
    private lateinit var Email: EditText
    private lateinit var Username: EditText
    private lateinit var Password: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        Nama_Lengkap= findViewById(R.id.full_name)
        Email = findViewById(R.id.email)
        Username = findViewById(R.id.username)
        Password= findViewById(R.id.password)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        var intent = intent.extras
        if (intent!=null){
            var user = database.userDao().get(intent.getInt("id"))
            Nama_Lengkap.setText(user.Nama_Lengkap)
            Email.setText(user.Email)
            Username.setText(user.Username)
            Password.setText(user.Password)

        }

        btnSave.setOnClickListener {
            if(Nama_Lengkap.text.isNotEmpty() && Email.text.isNotEmpty() && Username.text.isNotEmpty() && Password.text.isNotEmpty()){
                if(intent!=null){
                    // Edit Data
                    database.userDao().update(User(
                        intent.getInt("id",0),
                        Nama_Lengkap.text.toString(),
                        Email.text.toString(),
                        Username.text.toString(),
                        Password.text.toString()
                    ))
                }
                else{
                    // Tambah Data
                    database.userDao().insertAll(
                        User(
                            null,
                            Nama_Lengkap.text.toString(),
                            Email.text.toString(),
                            Username.text.toString(),
                            Password.text.toString()
                        ))
                }

                finish()
            }
            else{
                Toast.makeText(applicationContext,"Masukkan semua data dengan benar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}