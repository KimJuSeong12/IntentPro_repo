package com.example.reintentpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.reintentpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCallActivity2.setOnClickListener {
            // 명시적 인텐트
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", "홍길동")
            intent.putExtra("age", 24)
            startActivity(intent)
        }
        binding.btnCallActivity3.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("name", "홍길여")
            intent.putExtra("age", 33)
            startActivity(intent)
        }

        binding.btnCallActivity4.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("x", 45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "+")
            startActivityForResult(intent, 20)
        }

        binding.btnCallActivity5.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("x", 954)
            intent.putExtra("y", 386)
            intent.putExtra("operator", "-")
            startActivityForResult(intent, 10)
        }

        val activityResultLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                // 콜백함수
                if (it.data?.getIntExtra("requestCode", 0) == 60) {
                    Toast.makeText(
                        applicationContext,
                        "${it.data?.getIntExtra("sum", 0)}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (it.data?.getIntExtra("requestCode", 0) == 70) {
                    android.widget.Toast.makeText(
                        applicationContext,
                        "${it.data?.getIntExtra("sum", 0)}",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
            }

        binding.btnCallActivity6.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("x", 45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "+")
            intent.putExtra("requestCode", 60)
            activityResultLauncher.launch(intent)
        }

        binding.btnCallActivity7.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            intent.putExtra("x", 999)
            intent.putExtra("y", 999)
            intent.putExtra("operator", "%")
            intent.putExtra("requestCode", 70)
            activityResultLauncher.launch(intent)
        }

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 20 && resultCode == RESULT_OK) {
//            Toast.makeText(applicationContext, "${data?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT)
//                .show()
//        } else if (requestCode == 10 && resultCode == RESULT_OK) {
//            Toast.makeText(applicationContext, "${data?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT)
//                .show()
//        } else {
//            Toast.makeText(applicationContext, "계산결과 오류입니다.", Toast.LENGTH_SHORT).show()
//        }
//    }
}