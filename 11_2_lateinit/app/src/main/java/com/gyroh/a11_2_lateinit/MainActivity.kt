package com.gyroh.a11_2_lateinit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.gyroh.a11_2_lateinit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 지연초기화
    // lateinit var 변수명:타입
    lateinit var name:String
    lateinit var person:Person
    // String은 기본형이 아님 기본형 : Int, Float, Long, Double

    //val 변수명 by lazy {변수에 들어갈 클래스생성자}
    val age by lazy { Person() } //lazy는 기본형도 쓸수 있음 ex) 21 같은 숫자 -> 큰 값을 지연초기화하는데 쓰긴함
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        person = Person()

        name = "Scott"
        if(){
            name = "kelly"
        }

    }
}

class Person{
    var name = ""
    var age = ""
    var address = ""
    var tel = ""
}

// 1. 클래스
// 2. Null Safety