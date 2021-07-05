package io.github.persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.persistence.databinding.ActivityMainBinding
import io.github.persistence.databinding.ShoppingItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    private lateinit var myShoppingList: MutableList<ShoppingModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(myShoppingList)
        binding.recyclerView.adapter = myShoppingAdapter

        binding.button.setOnClickListener {
            val category : String = binding.editText.text.toString()
            val description : String = binding.editText2.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            myShoppingList.add(shoppingItem)
            myShoppingAdapter.notifyDataSetChanged()
        }
    }
}