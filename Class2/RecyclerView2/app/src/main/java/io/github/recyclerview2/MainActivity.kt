package io.github.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import io.github.recyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val names: List<String> = listOf(
            "Felix",
            "Timothy",
            "Nneka",
            "Sonia",
            "Kenneth",
            "Efe",
            "Juliet",
            "Aghogho",
            "Kanayo",
            "Peter",
            "Andrew",
            "Felix",
            "Timothy",
            "Nneka",
            "Sonia",
            "Kenneth",
            "Efe",
            "Juliet",
            "Aghogho",
            "Kanayo",
            "Peter",
            "Andrew",
            "Felix",
            "Timothy",
            "Nneka",
            "Sonia",
            "Kenneth",
            "Efe",
            "Juliet",
            "Aghogho",
            "Kanayo",
            "Peter",
            "Andrew",
            "Felix",
            "Timothy",
            "Nneka",
            "Sonia",
            "Kenneth",
            "Efe",
            "Juliet",
            "Aghogho",
            "Kanayo",
            "Peter",
            "Andrew"
        )

        myAdapter = MyRecyclerViewAdapter(names)
        binding.recyclerView.adapter = myAdapter
        
    }
}