package com.gyroh.a13_listener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val listener = object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                Log.d("리스너","클릭되었습니다.")
//            }
//        }
//        button1.setOnClickListener(listener)
        //이렇게 한줄로 집약이 가능하다 함수가 하나라면.
        // 하지만 안에 정의된 override fun 함수가 두개 이상이면 컴파일러가 추측불가능해서 불가
        button1.setOnClickListener{
            Log.d("리스너","클릭되었습니다.")
        }

    }
}