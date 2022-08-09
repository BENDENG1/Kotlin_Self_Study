package com.gyroh.a14_1_activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gyroh.a14_1_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) { // Entry Point (시작점)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnstart.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("from1","Hello Bundle") //값을 보냄
            intent.putExtra("from2",2022)
            startActivityForResult(intent,99)
        }
        
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                99 -> {
                    data?.getStringExtra("returnValue").let { message ->
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}