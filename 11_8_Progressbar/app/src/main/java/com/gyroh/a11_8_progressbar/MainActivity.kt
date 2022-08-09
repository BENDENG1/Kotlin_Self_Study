package com.gyroh.a11_8_progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gyroh.a11_8_progressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with (binding){
            // -> 메인 스레드
            showProgress(true)
            thread(start=true){ // -> 서브스레드
                Thread.sleep(3000)
                // 화면에 영향을 미치는 코드는 메인스레드로 다시 보내야 한다.
                runOnUiThread {
                    showProgress(false)
                    //progressLayout.visibility = View.GONE
                }
            } // -> 서브 스레드
            // -> 메인 스레드
        }

    }

    fun showProgress(show : Boolean){
        binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }
    //다섯줄 코드를 위에 처럼 축약 가능.
//    fun showProgress(show : Boolean){
//        if (show){
//            binding.progressLayout.visibility = View.VISIBLE
//        } else {
//            binding.progressLayout.visibility = View.GONE
//        }
//    }
}