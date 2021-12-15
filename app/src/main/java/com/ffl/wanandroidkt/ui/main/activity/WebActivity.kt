package com.ffl.wanandroidkt.ui.main.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ffl.baselib.helper.MMKVHelper
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.Constants
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
        webView.post {
            injectJs()
        }
        viewMask.visibility =
            if (MMKVHelper.getInstance().getBoolean(Constants.KEY_NIGHT_MODE, false)) View.VISIBLE else View.GONE

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

    fun injectJs() {
        if (MMKVHelper.getInstance().getBoolean(Constants.KEY_NIGHT_MODE, false)) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                webView.evaluateJavascript(
                    "document.body.style.backgroundColor=\"black\";document.body.style.color=\"white\";",
                    null
                )
            } else {
                webView.loadUrl("javascript:document.body.style.backgroundColor=\"#black\";document.body.style.color=\"white\";")
            }
        } else {
            //API19，android4.4及以下无法分开处理
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                webView.evaluateJavascript(
                    "document.body.style.backgroundColor=\"white\";document.body.style.color=\"black\";",
                    null
                )
            } else {
                webView.loadUrl("javascript:document.body.style.backgroundColor=\"#white\";document.body.style.color=\"black\";")
            }
        }
    }
}