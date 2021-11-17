package com.ffl.wanandroidkt.ui.main.presenter

import com.ffl.wanandroidkt.http.HttpUtils
import com.ffl.wanandroidkt.http.MainApi
import com.ffl.wanandroidkt.http.RequestListener
import com.ffl.wanandroidkt.mvp.model.BaseModel
import com.ffl.wanandroidkt.mvp.presenter.BasePresenter
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.ui.main.view.MainView

class MainPresenter : BasePresenter<MainView>() {

    /**
     * 获取首页文章列表
     * @param pageNum 页码
     */
    fun getHomeArticleList(pageNum: Int) {
        HttpUtils.sendHttp(HttpUtils.createApi(MainApi::class.java).getHomeArticleList(pageNum), object :
            RequestListener<BaseModel<MainModel>> {
            override fun onSuccess(data: BaseModel<MainModel>) {
                if (data.errorCode == 0) {
                    getBaseView()!!.setMainData(data.data, 101)
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
     * 获取首页banner
     */
    fun getHomeBanner() {
        HttpUtils.sendHttp(
            HttpUtils.createApi(MainApi::class.java).getHomeBanner(),
            object : RequestListener<BaseModel<List<BannerModel>>> {
                override fun onSuccess(data: BaseModel<List<BannerModel>>) {
                    if (data.errorCode == 0) {
                        getBaseView()!!.setMainData(data.data, 102)
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
     * 获取置顶文章
     */
    fun getHomeTopArticles() {
        HttpUtils.sendHttp(HttpUtils.createApi(MainApi::class.java).getHomeTopArticles(), object :
            RequestListener<BaseModel<List<MainModel.DatasBean>>> {
            override fun onSuccess(data: BaseModel<List<MainModel.DatasBean>>) {
                if (data.errorCode == 0) {
                    getBaseView()?.setMainData(data.data, 103)
                } else {
                    getBaseView()?.setError(data.errorMsg)
                }
            }

            override fun onFail(str: String) {
                getBaseView()!!.setError(str)
            }
        })
    }
}
