package io.github.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import io.github.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val names: List<String> = listOf(
            "Emmanuel",
            "Uche",
            "Isaac",
            "Judith",
            "Benedicta",
            "Noah",
            "Cletus",
            "Kelvin",
            "Eddie",
            "Emmanuel",
            "Uche",
            "Isaac",
            "Judith",
            "Benedicta",
            "Noah",
            "Cletus",
            "Kelvin",
            "Eddie",
            "Emmanuel",
            "Uche",
            "Isaac",
            "Judith",
            "Benedicta",
            "Noah",
            "Cletus",
            "Kelvin",
            "Eddie",
            "Emmanuel",
            "Uche",
            "Isaac",
            "Judith",
            "Benedicta",
            "Noah",
            "Cletus",
            "Kelvin",
            "Eddie"
        )
        myAdapter = RecyclerViewAdapter(names)
        binding.recycler.adapter = myAdapter
    }
}