package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.reintentpro.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    val binding: ActivityMain3Binding by lazy { ActivityMain3Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = this.intent.getStringExtra("name")
        val age = this.intent.getIntExtra("age", 30)

        binding.ivPicture2.setOnClickListener {
            Toast.makeText(applicationContext, "${name},${age}", Toast.LENGTH_SHORT).show()
        }

    }
}