package io.github.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.retrofit.databinding.TodoItemBinding

class TodoAdapter(var list: List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(todo: Todo){
            binding.textView.text = todo.title
            if (todo.completed){
                binding.imageView.visibility = View.VISIBLE
            }else{
                binding.imageView.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val singleTodo = list.get(position)
        holder.bind(singleTodo)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}