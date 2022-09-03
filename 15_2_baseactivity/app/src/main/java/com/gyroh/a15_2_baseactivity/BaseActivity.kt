package com.gyroh.a15_2_baseactivity

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.security.Permissions


//BaseActivity를 상속받아서 mainActivity가 동작할거임
//open이거나 상속을 받아야함 근데 우리는 추상할거임
//abstract
abstract class BaseActivity : AppCompatActivity() {

    // abstract를 한 이유는 상속받은것과 연계하기 위해서 강요하기 위해서 abstract를 사용
    // 코드블럭을 지우고 상속받은곳에서는 강제적으로 코드를 구현해야함
    abstract fun permissionsGranted(requestCode: Int) //메인 엑티비티에서 구현하게됨
    abstract fun permissionsDenied(requestCode: Int)

    // 권한 검사
    fun requirePermissions(permissions:Array<String>, requestCode:Int){
        // Api 버전이 마시멜로 이하이면 권한처리가 필요없다
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            permissionsGranted(requestCode)
        } else{
            // 권한이 없으면 권한 요청 -> 팝업
            ActivityCompat.requestPermissions(this,permissions,requestCode)
        }
    }

    // 권한관련 승인,거절에 대한 결과 처리
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        // grantResults에 대해 처리 -> 일반적으로 for문을 사용
        // 이렇게컬렉션같은것은 all이 사용 가능
        if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
            permissionsGranted(requestCode)
        } else{
            permissionsDenied(requestCode)
        }
//        for (result in grantResults){
//            if (result == PackageManager.PERMISSION_GRANTED){
//
//            }
//        }
    }

}