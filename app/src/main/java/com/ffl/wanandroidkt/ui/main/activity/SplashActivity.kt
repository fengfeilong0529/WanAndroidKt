package com.ffl.wanandroidkt.ui.main.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.ffl.wanandroidkt.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private var mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        initData()
        initListener()
    }

    private fun initListener() {
        tvSkip.setOnClickListener {
            mHandler.removeCallbacksAndMessages(null)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    fun initData() {
        mHandler.postDelayed({
            //跳转到主界面
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
