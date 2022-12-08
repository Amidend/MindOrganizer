package main.mindorganizer.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(taskModel: TaskModel):Long

    @Query("Select * from tasks where id =:uid")
    suspend fun getOneTask(uid:Int):TaskModel

    @Query("Select * from tasks where finished == 0")
    fun getTask():LiveData<List<TaskModel>>

    @Update
    fun changeTask(taskModel: TaskModel)

    @Query("Update tasks Set finished = 1 where id=:uid")
    suspend fun finishTask(uid:Long)

    @Query("Delete from tasks where id=:uid")
    suspend fun deleteTask(uid:Long)
}