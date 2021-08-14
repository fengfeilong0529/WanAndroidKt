package com.ffl.wanandroidkt.http

import com.ffl.wanandroidkt.mvp.model.BaseModel
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {

    /**
     * 获取首页文章列表
     * http://www.wanandroid.com/article/list/0/json
     * @param pageNum
     */
    @GET("/article/list/{pageNum}/json")
    fun getHomeArticleList(@Path("pageNum") pageNum: Int): Observable<BaseModel<MainModel>>

    @GET("/banner/json")
    fun getHomeBanner(): Observable<BaseModel<List<BannerModel>>>

}