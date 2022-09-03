package com.gyroh.a15_1_permission

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gyroh.a15_1_permission.databinding.ActivityMainBinding
import java.util.*

/*
권한처리는 일반권한과 위험권한으로 나뉨
위험권한은 개인정보와 관련된 정보를 앱이 필요로 할대 사용자한테 한번 더 물어보는 과정을 거침
 */
class MainActivity : AppCompatActivity() {

    //바인딩을 하는 이유 -> 버튼을 클릭했을때 동작하기 위해 버튼에 액세스 하는것임
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {
            checkPermission()
        }

    }

    fun checkPermission() {
        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        if (cameraPermission== PackageManager.PERMISSION_GRANTED){
            openCamera()
        }else{
            //기존 구현되어있는 requestPermissions()와 다름 -> 직접 구현
            requestPermission()
        }
    }

    fun openCamera(){
//        Toast.makeText(this,"카메라를 실행합니다",Toast.LENGTH_SHORT).show()
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }
    fun requestPermission(){
        //실제 권한 요청
        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),99)
        //requestcode
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //requestPermissions에서 요청하는 권한처리 일때 권한(grant)체크
        //권한을 하나만 우리는 보앴으니깐 grantresult의 어레이의 첫번째 값만 넘어온
        when(requestCode){
            99 ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera()
                } else{
                    Toast.makeText(this,"권한을 승인하지 않으면 앱이 종료됩니다.",Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}