package com.ffl.wanandroidkt.ui.main.view

import com.ffl.wanandroidkt.mvp.view.BaseView

interface MainView : BaseView {

     fun <T> setMainData(data: T, code: Int){

     }
}