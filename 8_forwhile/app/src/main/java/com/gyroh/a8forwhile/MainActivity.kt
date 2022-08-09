package com.gyroh.a8forwhile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intA = IntArray(10)
        var intArray = intArrayOf(0,10,20,30,40,50,60,70,80)


        //for
        //일반적으로 몇 번의 횟수를 반복하는 형태
        for(index in 1..10){
            //코드블럭
            Log.d("반복문","index = ${index}")
        }
        for(index in 1 until 10){
            //코드블럭
            Log.d("반복문","index = ${index}")
        }
        for(index in 1 until 10 step 2){
            //코드블럭
            Log.d("반복문","index = ${index}")
        }
        for(index in 10 downTo 1 step 2){
            //코드블럭
            Log.d("반복문","index = ${index}")
        }
        //범위값
        for(value in intArray){
            Log.d("반복문","index=${value}")
        }

        //while
        var out = 3
        while (out < 3){
            Log.d("while","현재 out 카운트=${out}")
            out += 1
        }
        do{
            Log.d("while","현재 out 카운트=${out}")
            out += 1
        }while (out < 3)

        //control loop
        for(index in 0..10){
            //continue, break 차이
            if(index > 5) continue
            Log.d("포","현재 숫자=${index}")
        }

    }
}