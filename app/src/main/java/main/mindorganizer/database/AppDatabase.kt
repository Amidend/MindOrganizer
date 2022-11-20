package main.mindorganizer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun todoDao(): TaskDao

    companion object {
        // Singleton
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todo.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}