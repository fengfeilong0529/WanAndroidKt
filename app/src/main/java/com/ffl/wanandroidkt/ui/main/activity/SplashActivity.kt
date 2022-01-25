package com.ffl.wanandroidkt.ui.main.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.ffl.baselib.helper.MMKVHelper
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.Constants
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
            toNextPage()
        }
    }

    fun initData() {
        mHandler.postDelayed({
            toNextPage()
        }, 3000)
    }

    private fun toNextPage() {
        val isFirstStart = MMKVHelper.getInstance().getBoolean(Constants.KEY_FIRST_START, true)
        if (isFirstStart) {
            //跳转到登录界面
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        } else {
            //跳转到主界面
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
        finish()
    }
}
