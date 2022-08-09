package com.gyroh.a14_7_customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyroh.a14_7_customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customview = CustomView(this)
        binding.frameLayout.addView(customview)
    }
}