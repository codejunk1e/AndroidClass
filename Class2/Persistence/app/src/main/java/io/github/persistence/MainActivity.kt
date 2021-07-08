package io.github.persistence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import io.github.persistence.databinding.ActivityMainBinding
import io.github.persistence.databinding.ShoppingItemBinding
const val CATEGORY_KEY =  "CATEGORY_KEY"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    private lateinit var myShoppingList: MutableList<ShoppingModel>
    private lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ShoppingViewModel::class.java]

        myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(myShoppingList)
        binding.recyclerView.adapter = myShoppingAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database"
        ).allowMainThreadQueries().build()


        viewModel.getAllShoppingItems(db).observe(this, {
            myShoppingAdapter = ShoppingAdapter(it)
            binding.recyclerView.adapter = myShoppingAdapter
            myShoppingAdapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            val category : String = binding.editText.text.toString()
            val description : String = binding.editText2.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            viewModel.addShoppingItem(shoppingItem, db)

            myShoppingAdapter.notifyDataSetChanged()
        }
    }
}
