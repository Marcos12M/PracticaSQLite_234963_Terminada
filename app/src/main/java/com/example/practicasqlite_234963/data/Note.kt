package com.example.practicasqlite_234963.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    val title: String,
    val description: String,
    val dateAdded: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)