package com.gyroh.sayhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyroh.sayhello.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSay.setOnClickListener {
            binding.textSay.text ="Hello Kotlin!"
        }
    }
}