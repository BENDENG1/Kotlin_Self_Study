package com.gyroh.a15_2_baseactivity

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.gyroh.a15_2_baseactivity.databinding.ActivityMainBinding


//mainactivity가 baseactivity()를 상속받음
class MainActivity : BaseActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    val PER_CAMERA = arrayOf(Manifest.permission.CAMERA)
    val PER_STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    val REQ_STORAGE = 99
    val REQ_CAMERA = 100

    val TAKE_CAMERA = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    // val base = BaseActivity() -> abstract를 사용하면 인스턴스화x 생성자 호출 불가능
        // 앱이 시작되면 스토리지 권한을 처리한다.
        requirePermissions(PER_STORAGE,REQ_STORAGE)
        // 카메라 버튼이 클릭되면 권한처리 후 카메라를 오픈한다.
        binding.btnCamera.setOnClickListener {
            requirePermissions(PER_CAMERA, REQ_CAMERA)
        }
    }

    override fun permissionsGranted(requestCode: Int) {
        when(requestCode){
            REQ_STORAGE -> {
                Toast.makeText(this,"스토리지 권한이 승인되었습니다",Toast.LENGTH_SHORT)
            }
            REQ_CAMERA ->{
                openCamera()
            }
        }
    }

    override fun permissionsDenied(requestCode: Int) {
        when(requestCode){
            REQ_STORAGE -> {
                Toast.makeText(this,"스토리지 권한이 없으면 앱을 실행할 수 없습니다.",Toast.LENGTH_SHORT)
                finish()
            }
            REQ_CAMERA -> {
                Toast.makeText(this,"카메라 권한이 거절되었습니다",Toast.LENGTH_SHORT)
            }
        }
    }

    fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,TAKE_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            when(requestCode){
                TAKE_CAMERA ->{
                    //카메라 촬영 결과를 처리
                }
            }
        }
    }
}