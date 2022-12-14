package com.gyroh.a9kotlinsyntaxfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //함수를 사욘하는 용도 -> 코드를 분류하기 위해서


        functionName()
        var result = functionParam("값",1234)

        var pi = getPi()
        Log.d("파이","pi=${pi}")
    }

    // 기본 함수
    fun functionName(){
        //코드 블럭
    }
    // 입력값이 있는 함수
    fun functionParam(param1:String, param2:Int) : String{
        Log.d("함수","param1=${param1}, param2=${param2}")
        return "새로운 값"
    }
    // 출력값이 있는 함수
    fun getPi() : Double{
        return 3.141592
    }
}