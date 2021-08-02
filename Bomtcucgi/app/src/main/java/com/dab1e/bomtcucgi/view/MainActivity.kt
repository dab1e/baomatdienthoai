package com.dab1e.bomtcucgi.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

import com.dab1e.bomtcucgi.R
import com.dab1e.bomtcucgi.view.screenlock.ScreenLockActivity

class MainActivity : AppCompatActivity() {
    private val TIMEOUT:Long=2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) // sẽ ẩn tiêu đề
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        val r= Runnable {
            intent= Intent(this, ScreenLockActivity::class.java)
            startActivity(intent)
            finish()
        }
        Handler(Looper.getMainLooper()).postDelayed(r,TIMEOUT)


    }
}

