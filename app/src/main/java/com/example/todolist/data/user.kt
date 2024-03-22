package com.example.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("userdata")
data class user(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val data:String,

)
