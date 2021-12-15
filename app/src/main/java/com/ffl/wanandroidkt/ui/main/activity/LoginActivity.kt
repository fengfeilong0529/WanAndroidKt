package com.ffl.wanandroidkt.ui.main.activity

import android.content.Intent
import android.text.TextUtils
import com.ffl.baselib.helper.MMKVHelper
import com.ffl.baselib.util.GsonHelper
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseActivity
import com.ffl.wanandroidkt.base.Constants
import com.ffl.wanandroidkt.ui.main.model.LoginModel
import com.ffl.wanandroidkt.ui.main.presenter.LoginPresenter
import com.ffl.wanandroidkt.ui.main.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView {

    override fun getLayoutId() = R.layout.activity_login

    override fun initView() {
        btnLogin.setOnClickListener {
            toLogin()
        }
    }

    override fun initData() {
    }

    override fun createPresenter(): LoginPresenter? = LoginPresenter()

    private fun toLogin() {
        val userName = etUserName.text.toString().trim()
        val pwd = etPwd.text.toString().trim()
        if (TextUtils.isEmpty(userName)) {
            showToast("请输入用户名")
            return
        }
        if (TextUtils.isEmpty(pwd)) {
            showToast("请输入密码")
            return
        }
        showProgressDialog()
        getPresenter()!!.login(userName, pwd)
    }

    override fun <T> setData(data: T) {
        hideProgressDialog()
        if (data is LoginModel) {
            showToast("登录成功")
            //登录数据持久化
            MMKVHelper.getInstance().putBoolean(Constants.KEY_FIRST_START, false)
            MMKVHelper.getInstance().putString(Constants.KEY_LOGIN_DATA, GsonHelper.getInstance().toJsonStr(data))
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun setError(err: String) {
        hideProgressDialog()
        showToast(err)
    }
}
