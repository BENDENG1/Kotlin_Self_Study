package com.gyroh.a11basicsyntaxnullsafety

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 1. Nullable
        // 2. Safe Call
        // 3. Elvis Expression
        var myName:String = "메시"
        var number:Int? = null  //nullable
        var newVariable: Activity? = null

        Log.d("Null Test", "문자열의 길이는=${myName.length}")

        //Null이 아닐경우에
        var number2:Int = 30
        var result = number2.plus(50)

        //Null일경우에
//        number.plus() ///Null Pointer Exception
        //Null포인터를 방지하기 위해서 safe call
        //safe call  -> ?사용
        var result1 = number?.plus(37) ?: 51 //?: a -> Null일 경우에 a를 집어넣어라
        var result2 = result1.plus(53)

    }
}