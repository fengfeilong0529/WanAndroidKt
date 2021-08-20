package com.ffl.wanandroidkt.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.mvp.view.BaseView
import com.loading.dialog.AndroidLoadingDialog

abstract class BaseFragment<V, P : BasePresenter<V>> : Fragment(), BaseView {

    private var mPresenter: P? = null
    private var mProgressDialog: AndroidLoadingDialog? = null

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

    protected fun showToast(msg: String) {
        Toast.makeText(MyApp.context, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = AndroidLoadingDialog().setOnTouchOutside(false)
        }
        mProgressDialog!!.show(activity!!.fragmentManager, "")
    }

    protected fun hideProgressDialog() {
        mProgressDialog!!.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter!!.unbindView()
    }
}