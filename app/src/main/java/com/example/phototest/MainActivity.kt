package com.example.phototest

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    val addPhotoButton: Button by lazy {
        findViewById<Button>(R.id.addPhotoButton)
    }

    val startPhotoFrameModeButton: Button by lazy {
        findViewById<Button>(R.id.startPhotoFrameModeButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAddPhotoButton()
        initStartPhotoFrameModeButton()
    }

    private fun initAddPhotoButton(){
        addPhotoButton.setOnClickListener {
            when{
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED ->{
                    //TODO 권한이 잘 부여되었을때 갤러리에서 사진을 선택하는 기능
                }
                //activitycompat를 붙여야 오류가 안난다.
                ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                     //todo 권한 팝업 확인 후 띄우는 기능
                    showContextPermissionPopup()
                }
                else->{
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1000)
                }
            }
        }
    }
    private fun showContextPermissionPopup() {
        AlertDialog.Builder(this)
            .setTitle("권한이 요구됩니다")
            .setMessage("사진을 불러오기 위해 권한이 필요합니다. 그래야 전자액자에 전시 가능합니다")
            .setPositiveButton("동의하기")
            { _, _ ->
                ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            }
            .setNegativeButton("거절하기")
            { _, _ -> }
            .create()
            .show()

    }
    private fun initStartPhotoFrameModeButton(){

    }


}