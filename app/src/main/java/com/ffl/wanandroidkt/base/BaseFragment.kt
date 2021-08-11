package com.ffl.wanandroidkt.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.mvp.view.BaseView

abstract class BaseFragment<V, P : BasePresenter<V>> : Fragment(), BaseView {

    private var mPresenter: P? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter!!.bindView(this as V)
        initView(view)
        initData()
        return view
    }

    abstract fun createPresenter(): P?

    abstract fun getLayoutId(): Int

    protected abstract fun initView(view: View)

    protected abstract fun initData()

    fun getPresenter() = mPresenter

    @SuppressLint("ShowToast")
    protected fun showToast(msg: String) {
        Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter!!.unbindView()
    }
}