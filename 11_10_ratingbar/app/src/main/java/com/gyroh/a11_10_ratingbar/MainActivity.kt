package com.gyroh.a11_10_ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyroh.a11_10_ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with (binding){
            ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                if(fromUser)
                textView.text ="$rating"
            }
        }
    }
}