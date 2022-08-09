package com.gyroh.a4_variableuse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName = "노균욱"
        Log.d(TAG,"my name = $myName")
        myName = "홍길동"
        Log.d(TAG,"my name = $myName")
        val PI = 3.141592
        Log.d(TAG,"my name = $PI")

        var mynumbers = "1,2,3,4,5,6"
        var thisWeekNumbers = "1,2,3,4,5,6"

        if(mynumbers == thisWeekNumbers) {
            
        //Log.d(TAG, "당첨되엇습니다!")
        }else{
            Log.d(TAG,"당첨되지않았습니다..")
        }

        for(index in 1..10){
            Log.d(TAG,"현재 숫자는 ${index}입니다.")
        }
    }
}