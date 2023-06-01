package com.example.tugaspratikum34.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "full_name") var Nama_Lengkap: String?,
    @ColumnInfo(name = "email") var Email: String?,
    @ColumnInfo(name = "username") var Username: String?,
    @ColumnInfo(name = "password") var Password: String?,
)
