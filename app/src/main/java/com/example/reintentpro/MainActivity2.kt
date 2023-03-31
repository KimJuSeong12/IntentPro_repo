package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.example.reintentpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    val binding: ActivityMain2Binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = this.intent.getStringExtra("name")
        val age = this.intent.getIntExtra("age", 10)

        binding.ivPicture.setOnClickListener {
            Toast.makeText(applicationContext,"${name}, ${age}",Toast.LENGTH_SHORT).show()
        }
    }
}