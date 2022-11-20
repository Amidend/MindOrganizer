package main.mindorganizer.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskModel(
    @ColumnInfo(name = "text")
    var text:String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "date")
    var date:Long,
    @ColumnInfo(name = "time")
    var time:Long,
    @ColumnInfo(name = "finished")
    var isFinishedTask : Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
)