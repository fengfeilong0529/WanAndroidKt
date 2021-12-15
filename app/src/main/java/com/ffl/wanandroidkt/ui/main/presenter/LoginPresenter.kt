package com.ffl.wanandroidkt.ui.main.presenter

import com.ffl.wanandroidkt.http.HttpUtils
import com.ffl.wanandroidkt.http.MainApi
import com.ffl.wanandroidkt.http.RequestListener
import com.ffl.wanandroidkt.mvp.model.BaseModel
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.ui.main.model.LoginModel
import com.ffl.wanandroidkt.ui.main.model.RegisterModel
import com.ffl.wanandroidkt.ui.main.view.LoginView

class LoginPresenter : BasePresenter<LoginView>(){

    /**
     * 用户登录
     */
    fun login(userName: String, pwd: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(MainApi::class.java).login(userName, pwd),
            object : RequestListener<BaseModel<LoginModel>> {
                override fun onSuccess(data: BaseModel<LoginModel>) {
                    if (data.errorCode == 0) {
                        getBaseView()!!.setData(data.data)
                    } else {
                        getBaseView()!!.setError(data.errorMsg)
                    }
                }

                override fun onFail(str: String) {
                    getBaseView()!!.setError(str)
                }
            })
    }

    /**
     * 用户注册
     */
    fun register(userName: String, pwd: String, repwd: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(MainApi::class.java).register(userName, pwd, repwd),
            object : RequestListener<BaseModel<RegisterModel>> {
                override fun onSuccess(data: BaseModel<RegisterModel>) {
                    if (data.errorCode == 0) {
                        getBaseView()!!.setData(data.data)
                    } else {
                        getBaseView()!!.setError(data.errorMsg)
                    }
                }

                override fun onFail(str: String) {
                    getBaseView()!!.setError(str)
                }
            })
    }
}