package com.ffl.wanandroidkt.ui.main.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
        view.btnLogout.setOnClickListener {
            showLogoutDialog()
        }
        mTvUserName = view.tvUserName

        view.sivScore.setOnClickListener { showToast("我的积分") }
        view.sivShare.setOnClickListener { showToast("我的分享") }
        view.sivCollect.setOnClickListener { showToast("我的收藏") }
        view.sivSysSetting.setOnClickListener {
            startActivity(Intent(context, SysSettingActivity::class.java))
        }
    }

    private fun showLogoutDialog() {
        context?.let {
            AlertDialog.Builder(it)
                .setTitle("提示")
                .setMessage("确定要退出登录吗？")
                .setPositiveButton(
                    "确定"
                ) { _, _ -> startActivity(Intent(activity, LoginActivity::class.java)) }
                .setNegativeButton("取消", null)
                .show()
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