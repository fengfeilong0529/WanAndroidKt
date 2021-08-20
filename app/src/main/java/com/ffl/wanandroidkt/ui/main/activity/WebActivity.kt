package com.ffl.wanandroidkt.ui.main.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ffl.wanandroidkt.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        initView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView() {
        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")
        webView.loadUrl(url)
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true
    }

    companion object {
        /**
         * 打开网页
         */
        fun startActivity(context: Context, title: String, url: String) {
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
    }

}