package io.github.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.tab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var whatsAppAdapter: WhatsAppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        whatsAppAdapter = WhatsAppAdapter(supportFragmentManager)
        binding.pager.adapter = whatsAppAdapter
        binding.tabLayout.setupWithViewPager(binding.pager)
    }
}