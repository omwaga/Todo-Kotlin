package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rv_todoItems.adapter = todoAdapter
        rv_todoItems.layoutManager = LinearLayoutManager(this)

        btn_addTodo.setOnClickListener {
            val todoTitle = et_todoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                et_todoTitle.text.clear()
            }
        }
        btn_deleteDone.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}