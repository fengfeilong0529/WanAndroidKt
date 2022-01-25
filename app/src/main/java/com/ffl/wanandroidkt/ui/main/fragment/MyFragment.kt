package com.ffl.wanandroidkt.ui.main.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import com.ffl.baselib.helper.MMKVHelper
import com.ffl.baselib.util.GsonHelper
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseFragment
import com.ffl.wanandroidkt.base.Constants
import com.ffl.wanandroidkt.ui.main.activity.LoginActivity
import com.ffl.wanandroidkt.ui.main.activity.SysSettingActivity
import com.ffl.wanandroidkt.ui.main.model.LoginModel
import com.ffl.wanandroidkt.ui.main.presenter.MyPresenter
import com.ffl.wanandroidkt.ui.main.view.MyView
import kotlinx.android.synthetic.main.fragment_my.view.*

class MyFragment : BaseFragment<MyView, MyPresenter>() {

    private lateinit var mTvUserName: TextView

    override fun createPresenter(): MyPresenter? = MyPresenter()

    override fun getLayoutId() = R.layout.fragment_my

    override fun initView(view: View) {
        view.ivAvatar.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        mTvUserName = view.tvUserName

        view.sivScore.setOnClickListener { showToast("我的积分") }
        view.sivShare.setOnClickListener { showToast("我的分享") }
        view.sivCollect.setOnClickListener { showToast("我的收藏") }
        view.sivSysSetting.setOnClickListener {
            startActivity(Intent(context, SysSettingActivity::class.java))
        }
    }

    private fun setUI() {
        val loginData = MMKVHelper.getInstance().getString(Constants.KEY_LOGIN_DATA)
        val loginModel = GsonHelper.getInstance().fromJson(loginData, LoginModel::class.java)
        Log.i("MyFragment", "登录数据==》$loginModel")

        mTvUserName.text = loginModel.nickname
    }

    override fun initData() {

    }

    override fun onResume() {
        super.onResume()
        setUI()
    }

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }


}