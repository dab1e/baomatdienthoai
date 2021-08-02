package com.dab1e.bomtcucgi.view.screenlock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProvider
import com.dab1e.bomtcucgi.R
import com.dab1e.bomtcucgi.view.homeactivity.HomeActivity
import com.dab1e.bomtcucgi.viewmodel.ScreenLockViewModel
import kotlinx.android.synthetic.main.activity_screen_lock.*

class ScreenLockActivity : AppCompatActivity() {

    val arr= arrayOf<Int>(
        R.id.inputnumber1,
        R.id.inputnumber2,
        R.id.inputnumber3,
        R.id.inputnumber4
    )

    private val viewModel: ScreenLockViewModel by lazy {
        ViewModelProvider(this).get(ScreenLockViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) // sẽ ẩn tiêu đề
        supportActionBar!!.hide()
        setContentView(R.layout.activity_screen_lock)
        setEvent()


    }


    fun setnumberpass(number :Int){
        viewModel.onclickNumber(number).observe(this, androidx.lifecycle.Observer {

            val ovalstatus = findViewById(arr[it?.position!!]) as RelativeLayout
            ovalstatus.setBackgroundResource(it.background)
            if (it.position == 3) {
                if(it.suc) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }else{
                    textstatus.setText("Error")
                }
                var run = Runnable {
                    for (i in 0..3) {
                        val oval = findViewById(arr[i]) as RelativeLayout
                        oval.setBackgroundResource(R.drawable.white_round_border)
                    }
                }
                Handler(Looper.getMainLooper()).postDelayed(run,50)
            }else{textstatus.setText(number.toString())}

//            Toast.makeText(this,"input: "+it.position+"back: "+it.background,Toast.LENGTH_SHORT).show()

        })
    }
    fun deletepass(){
        viewModel.deletePass().observe(this, androidx.lifecycle.Observer {
            val ovalstatus = findViewById(arr[it?.position!!]) as RelativeLayout
            textstatus.setText("xóa")
            ovalstatus.setBackgroundResource(it.background)
//            Toast.makeText(this," delete: "+it.position,Toast.LENGTH_SHORT).show()
        })
    }

    private fun setEvent() {
        number0.setOnClickListener { setnumberpass(0) }
        number1.setOnClickListener { setnumberpass(1) }
        number2.setOnClickListener { setnumberpass(2) }
        number3.setOnClickListener { setnumberpass(3) }
        number4.setOnClickListener { setnumberpass(4) }
        number5.setOnClickListener { setnumberpass(5) }
        number6.setOnClickListener { setnumberpass(6) }
        number7.setOnClickListener { setnumberpass(7) }
        number8.setOnClickListener { setnumberpass(8) }
        number9.setOnClickListener { setnumberpass(9) }
        deletenumber.setOnClickListener {
            try{deletepass()}catch (e:Exception){} }
    }

}






