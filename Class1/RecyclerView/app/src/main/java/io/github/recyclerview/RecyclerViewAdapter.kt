package io.github.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.recyclerview.databinding.ActivityMainBinding
import io.github.recyclerview.databinding.RecyclerviewItemBinding

class RecyclerViewAdapter(val names: List<String>)
    :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder (var binding: RecyclerviewItemBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(name: String) {
            binding.studentName.text = name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RecyclerviewItemBinding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount(): Int {
        return names.size
    }
}