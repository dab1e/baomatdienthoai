package com.dab1e.bomtcucgi.view.homeactivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import com.dab1e.bomtcucgi.R
import com.dab1e.bomtcucgi.view.screenlock.ScreenLockActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var listimg = arrayListOf<String>("https://apecsoft.asia/public/media//thumb/xu-huong-app-thuong-mai-dien-tu-apecsoft-400x200.png"
        ,"https://upload.afkmobi.com/photos/afkmobi-com/2021/03/afkmobi_ba_dao_tam_quoc_ra_mat_anh_td.jpg"
        ,"https://i0.wp.com/sharebox.vn/wp-content/uploads/2020/03/ng-d%E1%BB%A5ng-hay-cho-iphone.jpg?resize=400%2C200&ssl=1"
        ,"https://84race.com/public/media/thumb/h%C6%B0%E1%BB%9Bng_d%E1%BA%ABn/stravemobile_thumnail-400x200.png"
        ,"https://microsoft365.com.vn/wp-content/uploads/2021/01/microsoft-teams-va-google-meet.png")

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) // sẽ ẩn tiêu đề
        supportActionBar!!.hide()
        setContentView(R.layout.activity_home)

        var adapter = ViewPagerAdapter(listimg,viewpagerhome)
//        viewpagerhome.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
//            , ViewGroup.LayoutParams.MATCH_PARENT)
        viewpagerhome.adapter = adapter

        handler = Handler()
        runnable = Runnable {
            viewpagerhome.currentItem = viewpagerhome.currentItem+1
        }
        viewpagerhome.registerOnPageChangeCallback(
            object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable,1500)
                }
            }
        )
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,1500)
    }



    override fun onBackPressed() {
        super.onBackPressed()
//        Toast.makeText(this,"back",Toast.LENGTH_SHORT).show()
//        val homeIntent = Intent(Intent.ACTION_MAIN)
//        homeIntent.addCategory(Intent.CATEGORY_HOME)
//        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//        startActivity(homeIntent)
        val intent = Intent(this, ScreenLockActivity::class.java)
        startActivity(intent)
        finish();

    }

    fun getLockScreenWallpaper(){

    }
    
}