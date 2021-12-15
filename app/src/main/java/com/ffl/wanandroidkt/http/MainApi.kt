package com.ffl.wanandroidkt.http

import com.ffl.wanandroidkt.mvp.model.BaseModel
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.LoginModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.ui.main.model.RegisterModel
import io.reactivex.Observable
import retrofit2.http.*

interface MainApi {

    /**
     * 获取首页文章列表
     * http://www.wanandroid.com/article/list/0/json
     * @param pageNum
     */
    @GET("/article/list/{pageNum}/json")
    fun getHomeArticleList(@Path("pageNum") pageNum: Int): Observable<BaseModel<MainModel>>

    /**
     * 获取置顶文章
     */
    @GET("/article/top/json")
    fun getHomeTopArticles(): Observable<BaseModel<List<MainModel.DatasBean>>>

    /**
     * 获取首页banner
     */
    @GET("/banner/json")
    fun getHomeBanner(): Observable<BaseModel<List<BannerModel>>>

    /**
     * 登录
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") userName: String,
        @Field("password") pwd: String
    ): Observable<BaseModel<LoginModel>>

    /**
     * 注册
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun register(
        @Field("username") userName: String,
        @Field("password") pwd: String,
        @Field("repassword") repwd: String
    ): Observable<BaseModel<RegisterModel>>

    /**
     * 退出登录
     */
    @GET("/user/logout/json")
    fun logout(): Observable<BaseModel<*>>

}