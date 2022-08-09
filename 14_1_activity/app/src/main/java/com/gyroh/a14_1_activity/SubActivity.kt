package com.gyroh.a14_1_activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyroh.a14_1_activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    val binding by lazy {ActivitySubBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            to1.text = intent.getStringExtra("from1")
            to2.text = "${intent.getIntExtra("from2", 0)}"  //defaultvalue로 숫자 설정 정해서 받음

            btnClose.setOnClickListener {
                val returnIntent = Intent()
                val message = editMessage.text.toString()
                returnIntent.putExtra("returnValue",message)
                setResult(Activity.RESULT_OK,returnIntent)
                finish()
            }
        }
    }
}