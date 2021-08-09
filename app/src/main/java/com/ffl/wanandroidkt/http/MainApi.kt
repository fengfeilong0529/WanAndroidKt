package com.ffl.wanandroidkt.http

import com.ffl.wanandroidkt.mvp.model.BaseModel
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET

interface MainApi {

    @GET("/article/list/1/json")
    fun getHomeArticleList(): Observable<BaseModel<MainModel>>

    @GET("/banner/json")
    fun getHomeBanner(): Observable<BaseModel<List<BannerModel>>>

}