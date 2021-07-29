package com.ffl.wanandroidkt.mvp.presenter

open class BasePresenter<V> {

    private var mBaseView: V? = null

    fun bindView(baseView: V) {
        this.mBaseView = baseView
    }

    fun unbindView() {
        this.mBaseView = null
    }

    fun getBaseView() = mBaseView
}