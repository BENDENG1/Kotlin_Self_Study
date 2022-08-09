package com.gyroh.a11_3_scopefunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gyroh.a11_3_scopefunction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //with
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //run, let, apply, also 함수
        studyRun()

        //with 활용 / 이렇게 kotlin extension처럼 이렇게 binding.을 with를 통해 코드량을 줄일수 있음
        binding.Button.setOnClickListener {  }
        binding.imageButton.setImageLevel(50)
        binding.textView.text = "반가워"
        with(binding){
            Button.setOnClickListener {  }
            imageButton.setImageLevel(50)
            textView.text = "반가워"
        }

    }


    // 스코프함수
    // run, let, apply, also
    // with
    // 1. run
    fun studyRun(){
        val phones = mutableListOf("010-1234-5678", "010-1111-1111", "010-2222-2222")
        val list = mutableListOf(1,2,3,4,5,6,7,8,9)
        val names = mutableListOf("Scott", "Kelly", "Michael")

        val seoulPeople = SeoulPeople()

//        seoulPeople.persons.add("Scott","010-1234-5678", 19))
//        위의 코드가 더러워진다는 문제가 있음

        val resultrun = seoulPeople.persons.run{
            add(Person("Kelly","010-1111-1111", 20))
            add(Person("Scott","010-1234-5678", 19))
            add(Person("Michael","010-2222-2222", 21))
            size
            //하지만 길어지는 경우에 어디에 add 되는 경우를 모를 수 있음
        }
        //위의 문제를 해결해주기 위해 이렇게 alias 할수 있음 persons ->
        val resultlet = seoulPeople.persons.let{ persons ->
            persons.add(Person("Scott","010-1234-5678", 22))
            persons.add(Person("Scott","010-1234-5678", 22))
            persons.add(Person("Scott","010-1234-5678", 22))
        }
        Log.d("스코프함수", "resultrun=${resultrun}")
        Log.d("스코프함수", "resultlet=${resultlet}")

        // apply also는 스코프 함수 안에서 자기 자신을 되돌려줌
        // persons에 반영된 반환해줌 마지막 코드에 상관없이 내가 scope를 돌린 변수를 반환
        val resultApply = seoulPeople.persons.apply {
            add(Person("Kelly","010-1111-1111", 20))
            add(Person("Scott","010-1234-5678", 19))
            add(Person("Michael","010-2222-2222", 21))
            11
        }

        Log.d("스코프함수", "resultApply=${resultApply}")

        val resultAlso = seoulPeople.persons.also { persons ->
            persons.add(Person("Kelly","010-1111-1111", 19))
            persons.add(Person("Scott","010-1234-5678", 20))
            persons.add(Person("Michael","010-2222-2222", 21))
            12
        }
        Log.d("스코프함수", "resultAlso=${resultAlso}")
    }
}

class SeoulPeople{
    val persons = mutableListOf<Person>()
    init{
//        persons.add(Person("Scott","010-1234-5678", 19))
//        persons.add(Person("Kelly","010-1111-1111", 20))
//        persons.add(Person("Michael","010-2222-2222", 21))
    }
}

data class Person(
    val name:String = "",
    val phone:String = "",
    val age:Int = 21
)