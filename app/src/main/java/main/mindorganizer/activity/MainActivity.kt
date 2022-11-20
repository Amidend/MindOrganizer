package main.mindorganizer.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import main.mindorganizer.R
import main.mindorganizer.database.AppDatabase
import main.mindorganizer.database.TaskModel
import main.mindorganizer.adapters.TaskAdapter


class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<TaskModel>()
    private var adapter = TaskAdapter(list)

    private val db by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        db.todoDao().getTask().observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            }else{
                list.clear()
                adapter.notifyDataSetChanged()
            }
        })
    }
    fun openNewTask(view: View) {
        startActivity(Intent(this, NewTaskActivity::class.java))
    }
}