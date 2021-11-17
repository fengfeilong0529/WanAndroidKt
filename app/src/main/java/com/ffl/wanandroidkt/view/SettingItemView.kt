package com.ffl.wanandroidkt.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ffl.wanandroidkt.R
import kotlinx.android.synthetic.main.view_setting_item.view.*

class SettingItemView : ConstraintLayout {

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private var mIvLogo: ImageView? = null
    private var mTvContent: TextView? = null
    private var mTvTip: TextView? = null

    private fun init(context: Context?, attrs: AttributeSet?) {
        val view = LayoutInflater.from(context).inflate(R.layout.view_setting_item, this, true)
        mIvLogo = view.ivLogo
        mTvContent = view.tvContent
        mTvTip = view.tvTip

        if (attrs != null) {
            val ta = context!!.obtainStyledAttributes(attrs, R.styleable.SettingItemView)
            val sivTip = ta.getString(R.styleable.SettingItemView_sivTip)
            val sivContent = ta.getString(R.styleable.SettingItemView_sivContent)
            val resourceId = ta.getResourceId(R.styleable.SettingItemView_sivLeftIconSrc, R.drawable.ic_score)
            val hideLeftIcon = ta.getBoolean(R.styleable.SettingItemView_sivLeftIconHide, false)
            mTvContent?.text = sivContent
            mTvTip?.text = sivTip
            mIvLogo?.setImageResource(resourceId)
            mIvLogo?.visibility = if (hideLeftIcon) View.GONE else View.VISIBLE
            ta.recycle()
        }
    }

    fun setLeftIcon(resId: Int) {
        mIvLogo?.setImageResource(resId)
    }

    fun setContent(content: String) {
        mTvContent?.setText(content)
    }

    fun setTip(tip: String) {
        mTvTip?.setText(tip)
    }


}