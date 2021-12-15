package com.ffl.wanandroidkt.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ffl.wanandroidkt.R
import kotlinx.android.synthetic.main.view_head_bar.view.*

class HeadView : ConstraintLayout {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private var mIvBack: ImageView? = null
    private var mIvMore: ImageView? = null
    private var mTvTitle: TextView? = null
    private var headClickListener: HeadClickListener? = null

    @SuppressLint("Recycle")
    fun init(context: Context?, attrs: AttributeSet?) {
        val view = LayoutInflater.from(context).inflate(R.layout.view_head_bar, this, true)
        mIvBack = view.ivBack
        mIvMore = view.ivMore
        mTvTitle = view.tvTitle
        mIvBack?.setOnClickListener {
            headClickListener?.onClickBack()
        }
        mIvMore?.setOnClickListener {
            headClickListener?.onClickMore()
        }
        mTvTitle?.setOnClickListener {
            headClickListener?.onClickTitle()
        }
        if (attrs != null) {
            val ta = context!!.obtainStyledAttributes(attrs, R.styleable.HeadView)
            val title = ta.getString(R.styleable.HeadView_hvTitle)
            mTvTitle?.text = title
            val leftDrawable = ta.getResourceId(R.styleable.HeadView_hvLeftIconSrc,R.drawable.ic_back)
            val rightDrawable = ta.getResourceId(R.styleable.HeadView_hvRightIconSrc,R.drawable.ic_score)
            val leftIconHide = ta.getBoolean(R.styleable.HeadView_hvLeftIconHide, false)
            val rightIconShow = ta.getBoolean(R.styleable.HeadView_hvRightIconShow, false)
            mIvBack?.setImageResource(leftDrawable)
            mIvMore?.setImageResource(rightDrawable)
            mIvBack?.visibility = if (leftIconHide) INVISIBLE else VISIBLE
            mIvMore?.visibility = if (rightIconShow) VISIBLE else INVISIBLE
            ta.recycle()
        }
    }

    fun setTitle(title: String) {
        mTvTitle?.setText(title)
    }

    fun setOnHeadClickListener(listener: HeadClickListener) {
        headClickListener = listener
    }

    interface HeadClickListener {
        fun onClickBack()
        fun onClickTitle()
        fun onClickMore()
    }
}