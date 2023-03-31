package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reintentpro.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    val binding: ActivityMain5Binding by lazy { ActivityMain5Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val x = this.intent.getIntExtra("x",0)
        val y = this.intent.getIntExtra("y",0)
        val operator = this.intent.getStringExtra("operator")
        var sum = 0
        when(operator){
            "+" -> sum = x + y
            "-" -> sum = x - y
            "%" -> sum = x % y
            "*" -> sum = x * y
        }
        binding.btnReturnActivity.setOnClickListener {
            intent.putExtra("sum",sum)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}