package io.github.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myMusicAdapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val songs : List<MusicModel> = listOf(
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", true
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            ),
            MusicModel(
                "Abule","Patoranking", false
            ),
            MusicModel(
                "Don Dada", "Timaya", false
            ),
            MusicModel(
                "Good morning Jesus", "Smith", false
            )
        )
        myMusicAdapter = MusicAdapter(songs)
        binding.recyclerView.adapter = myMusicAdapter
    }
}