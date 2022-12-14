package com.example.third

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Post(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val body: String) {

}
