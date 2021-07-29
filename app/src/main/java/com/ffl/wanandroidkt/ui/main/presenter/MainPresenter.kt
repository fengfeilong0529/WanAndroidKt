package com.ffl.wanandroidkt.ui.main.presenter

import com.ffl.wanandroidkt.http.HttpUtils
import com.ffl.wanandroidkt.http.MainApi
import com.ffl.wanandroidkt.http.RequestListener
import com.ffl.wanandroidkt.mvp.model.BaseModel
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.ui.main.view.MainView

class MainPresenter : BasePresenter<MainView>() {

    fun test(str: String) {
        getBaseView()!!.setData(str)
    }

    fun getHomeArticleList() {
        HttpUtils.sendHttp(HttpUtils.createApi(MainApi::class.java).getHomeArticleList(), object :
            RequestListener<BaseModel<MainModel>> {
            override fun onSuccess(data: BaseModel<MainModel>) {
                if (data != null) {
                    getBaseView()!!.setData(data)
//                    Log.e("FFL",data.data.toString())
                }
            }

            override fun onFail(str: String) {
                getBaseView()!!.setError(str)
            }
        })
    }
}