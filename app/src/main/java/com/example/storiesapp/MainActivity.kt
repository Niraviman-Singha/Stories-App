package com.example.storiesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storiesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.storyRecycle.layoutManager = LinearLayoutManager(this)
        val storyList = listOf<StoryModel>(
            StoryModel("The School", resources.getString(R.string.story1), R.drawable.story1)
        )

        binding.storyRecycle.adapter = StoryAdapter(storyList,){
                selectItem: StoryModel -> listItemClicked(selectItem)
        }

    }
    private fun listItemClicked(story:StoryModel){
        var intent = Intent(this@MainActivity, StoryActivity::class.java)
        intent.putExtra("title", story.title)
        intent.putExtra("details", story.details)
        intent.putExtra("img", story.img)
        startActivity(intent)
    }
}