package com.ffl.wanandroidkt.ui.main.activity

import android.util.Log
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseActivity
import com.ffl.wanandroidkt.ui.main.presenter.MainPresenter
import com.ffl.wanandroidkt.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        rbtnHome.setOnClickListener {
            getPresenter()!!.test("我是测试数据！")
        }
    }

    override fun initData() {
        getPresenter()!!.getHomeArticleList()
    }

    override fun createPresenter(): MainPresenter? = MainPresenter()

    override fun <T> setData(data: T) {
        Log.e("FFL", "-----------$data")

    }

    override fun setError(err: String) {
        Log.e("FFL", "出错了-----------$err")
    }

}
