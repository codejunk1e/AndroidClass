package io.github.recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.recyclerview2.databinding.RecyclerItemBinding

 class MyRecyclerViewAdapter(val names: List<String>)
     :RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){

    class MyViewHolder(var binding: RecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(name: String) {
            binding.studentName.text = name
        }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
         return MyViewHolder(binding)
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(names[position])
     }

     override fun getItemCount(): Int {
         return  names.size
     }
 }