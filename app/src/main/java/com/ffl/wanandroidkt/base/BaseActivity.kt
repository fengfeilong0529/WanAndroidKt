package com.ffl.wanandroidkt.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ffl.baselib.helper.MMKVHelper
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.mvp.view.BaseView
import com.ffl.wanandroidkt.utils.StateBarUtil
import com.loading.dialog.AndroidLoadingDialog

abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {

    private var mPresenter: P? = null
    private var mProgressDialog: AndroidLoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContentView()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter!!.bindView(this as V)
        initView()
        initData()
    }

    open fun beforeSetContentView() {
        //设置状态栏深色字体
        if (!MMKVHelper.getInstance().getBoolean(Constants.KEY_NIGHT_MODE, false)) {
            StateBarUtil.setStateBarFont(window.decorView)
        }
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun createPresenter(): P?

    fun getPresenter() = mPresenter

    protected fun showToast(msg: String) {
        Toast.makeText(MyApp.context, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = AndroidLoadingDialog().setOnTouchOutside(false)
        }
        mProgressDialog!!.show(fragmentManager, "")
    }

    protected fun hideProgressDialog() {
        mProgressDialog!!.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unbindView()
    }
}
