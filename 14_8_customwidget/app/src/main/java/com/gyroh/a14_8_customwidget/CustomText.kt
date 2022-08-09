package com.gyroh.a14_8_customwidget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


// AppCompatTextView -> 호환 때문에 사용
class CustomText : AppCompatTextView{

    //프라이머리 생성자에서는 뷰를 상속 받을때 생성자를 넘겨줬었는데
    // 세컨 생성자는 super를 사용해서 부모한테 주는거임임
   constructor(context: Context) : super(context) { }

    //태그로 썼을때 attrs로 들어옴, 안드로이드가 받아서 처리
    constructor(context: Context, attrs:AttributeSet) : super(context, attrs) {
        val attrlist = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
//        val size = typed.indexCount

        for (i in 0 until attrlist.indexCount){

            val attr = attrlist.getIndex(i)

            when(attr){
                R.styleable.CustomText_delimeter -> {
                    attrlist.getString(attr)?.let {
                        process(it)
                    }
                }
            }
        }
    }

    //int -> 테마 같은건데. 스타일이 넘어올때 세번째 파라미너톨 사용
    constructor(context: Context, attrs:AttributeSet, defStyleAttr:Int) : super(context, attrs,defStyleAttr) { }

    fun process(dl: String){
        if (text.length == 8){
            val first4 = text.substring(0,4)
            val mid2 = text.substring(4,6)
            val last2 = text.substring (6)

            text = first4 + dl + mid2 + dl + last2

        }
    }
}