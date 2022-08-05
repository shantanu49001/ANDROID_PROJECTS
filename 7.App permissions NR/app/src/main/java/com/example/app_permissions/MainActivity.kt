package com.example.app_permissions

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Manifest
const val PERMISSION_REQUEST_PHONE_CALL=0
class MainActivity : AppCompatActivity(),ActivityCompat.OnRequestPermissionsResultCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callSupport=findViewById<Button>(R.id.button)
        callSupport.setOnClickListener {
            makePhoneCallAfterPermission(it)//here it means the bytton
        }
    }

    private fun makePhoneCallAfterPermission(view:View){//here view meabs th e button activity
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)==
                PackageManager.PERMISSION_GRANTED){
            makePhoneCall()
        }else{
            requestCallPermission(view)
        }


    }
    private fun requestCallPermission(view:View){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
            val snack=Snackbar.make(view,"WE NEED PERMISSION FOR CALL",Snackbar.LENGTH_INDEFINITE)
            snack.setAction("ok", View.OnClickListener {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),
                PERMISSION_REQUEST_PHONE_CALL)
            })
            snack.show()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),PERMISSION_REQUEST_PHONE_CALL)
        }
    }
    private fun makePhoneCall(){
        val intent=Intent().apply {
            action=ACTION_CALL
            data= Uri.parse("tel:9935768423")
        }
        startActivity(intent)
    }

override fun onRequestPermissionResult(requestCode:Int,permission: Array<String>,grantResults:IntArray) {
    if (requestCode== PERMISSION_REQUEST_PHONE_CALL){
        if (grantResults.size==1&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            makePhoneCall()
        }else{
            Toast.makeText(this,"permission denied",Toast.LENGTH_SHORT).show()
        }
    }
}
}