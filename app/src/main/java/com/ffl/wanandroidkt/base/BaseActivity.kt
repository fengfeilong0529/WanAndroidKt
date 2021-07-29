package com.ffl.wanandroidkt.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.mvp.view.BaseView

abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {

    private var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter!!.bindView(this as V)
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun createPresenter(): P?

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unbindView()
    }
}
