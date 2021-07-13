package io.github.persistence

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.persistence.databinding.ShoppingItemBinding

class ShoppingAdapter(
    val shoppingItems: List<ShoppingModel>,
    val clickerFnx: (ShoppingModel) -> Unit
    ) : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ShoppingItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(shoppingItem :ShoppingModel){
            binding.category.text = shoppingItem.category
            binding.description.text = shoppingItem.description
            binding.root.setOnClickListener {
                clickerFnx(shoppingItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ShoppingItemBinding =
            ShoppingItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
        holder.bind(shoppingItems.get(position))
    }
    override fun getItemCount() = shoppingItems.size
}