package com.ffl.wanandroidkt.ui.main.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import com.ffl.baselib.util.GsonHelper
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseFragment
import com.ffl.wanandroidkt.base.Constants
import com.ffl.wanandroidkt.ui.main.activity.LoginActivity
import com.ffl.wanandroidkt.ui.main.model.LoginModel
import com.ffl.wanandroidkt.ui.main.presenter.MyPresenter
import com.ffl.wanandroidkt.ui.main.view.MyView
import com.tencent.mmkv.MMKV
import kotlinx.android.synthetic.main.fragment_my.view.*

class MyFragment : BaseFragment<MyView, MyPresenter>() {

    override fun createPresenter(): MyPresenter? = MyPresenter()

    override fun getLayoutId() = R.layout.fragment_my

    override fun initView(view: View) {
        view.ivAvatar.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        val loginData = MMKV.defaultMMKV().decodeString(Constants.KEY_LOGIN_DATA)
        val loginModel = GsonHelper.getInstance().fromJson(loginData, LoginModel::class.java)
        Log.i("MyFragment", "登录数据==》${loginModel.toString()}")

        view.tvUserName.text = loginModel.nickname
    }

    override fun initData() {
//        val loginData = MMKV.defaultMMKV().decodeString(Constants.KEY_LOGIN_DATA)
//        val loginModel = GsonHelper.getInstance().fromJson(loginData, LoginModel::class.java)
//        Log.i("MyFragment", "登录数据==》${loginModel.toString()}")
//
//        tvUserName.text = loginModel.nickname
    }

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }


}