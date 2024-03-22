package com.example.todolist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface userdao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
 fun insert(user:user)
@Query("SELECT * FROM  userdata ORDER BY id ASC")
 fun readdata():LiveData<List<user>>
 @Update
 fun updatedata(user: user)
@Delete
fun deletedata(user: user)
}