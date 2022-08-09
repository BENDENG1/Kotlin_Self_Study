package com.gyroh.a9kotlinsyntaxclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //클래스의 사용 / 클래스를 항상 초기화야해야함
        // 1. 초기화
        var cls = 클래스() // 인스턴스 = 메모리에 로드되어 있는 클래스
        cls.variable
        cls.function()

        // 2. compantion object로 만들기
        Log.d("태그","메시지")

        var child=Child()
        child.showMoney()
        child.showHouse()

        var parent = Parent()
        parent.showHouse();

        var son = Son()
        var result1 = son.getNumber("홍")

    }
}

class Log{
    companion object{
        var variable = "난 누구"
        fun d(tag:String, msg:String){
            print("[$tag] : $msg")
        }
    }
}


//클래스 변수(property)와 함수(method)의 모음
class 클래스{
//    init{
//        //클래스를 초기화하면 호출된다.
//    }
    //클래스 scope
    var variable:String = "" //변수 - 프로퍼티

    fun function(){         //함수 - 메서드
        var variable_local = ""
    }
}


//상속을 사용하는 이유
//1. 기존의 작성된 코드를 재활용하기 위해서
//2. 코드를 재활용하는데 -> 체계적으로 계층구조로 사용하기 위해서
open class Parent{
    var money = 5000000000
    open var house = "강남 200평 아파트"

    open fun showHouse (){
        Log.d("클래스","my house=${house}")
    }
}

class Child : Parent(){
    //상속받으면, 아빠클래스의 프로퍼티와 메서드를 내것처럼 사용할 수 있다.

    //이렇게 동일한 이름을 가진 프로퍼티나 메서드를 정의할때 재정의 할때 (오버라이딩)
    override var house = "강남 10평 오피스텔"
    fun showMoney(){
        Log.d("클래스","money=${money}")
    }

    override fun showHouse (){
        Log.d("클래스","my house=${house}")
    }
}

class Son{
    //오버로딩 함수의 재정의를 하는데 이렇게 변수의 입력의 차이로 가능하다는것임
    fun getNumber(zergling:String) :Int{
        return 1
    }
    fun getNumber(zerg:String,hidra:String) : Int{
        return 2
    }
}