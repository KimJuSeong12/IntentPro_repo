package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reintentpro.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    val binding: ActivityMain6Binding by lazy { ActivityMain6Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val x = this.intent.getIntExtra("x",-1)
        val y = this.intent.getIntExtra("y",-1)
        val operator = this.intent.getStringExtra("operator")
        var sum = 0
        when(operator){
            "+" -> sum = x + y
            "-" -> sum = x - y
            "*" -> sum = x * y
            "%" -> sum = x % y
        }
        binding.tvX.text = x.toString()
        binding.tvY.text = "${y}"
        binding.tvSum.text = sum.toString()

        binding.btnReturnMain.setOnClickListener {
            intent.putExtra("sum",sum)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}