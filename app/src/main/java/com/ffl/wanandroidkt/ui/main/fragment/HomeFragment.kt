package com.ffl.wanandroidkt.ui.main.fragment

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseFragment
import com.ffl.wanandroidkt.ui.main.adapter.HomeRvAdapter
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.ui.main.presenter.MainPresenter
import com.ffl.wanandroidkt.ui.main.view.MainView
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : BaseFragment<MainView, MainPresenter>(), MainView {

    private var mHomeList = mutableListOf<MainModel.DatasBean>()
    private var mAdapter = HomeRvAdapter(R.layout.item_home_rv, mHomeList)
    private var mRvHome: RecyclerView? = null

    override fun createPresenter() = MainPresenter()

    override fun getLayoutId() = R.layout.fragment_home

    override fun initView(view: View) {
        mRvHome = view.findViewById(R.id.rvHome)
        view.rvHome.layoutManager = LinearLayoutManager(activity)
        view.rvHome.adapter = mAdapter
        mAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                val link = mAdapter.data[position].link
                Log.e("FFL", "子条目点击--------$position----------$link")
            }
        })
    }

    override fun initData() {
        getPresenter()!!.getHomeArticleList()
        getPresenter()!!.getHomeBanner()
    }

    override fun <T> setData(data: T) {
        Log.e("FFL", "-----------$data")
        if (data is MainModel) {
            mAdapter.setNewData(data.datas as MutableList<MainModel.DatasBean>?)
        } else if (data is BannerModel) {

        }
    }

    override fun setError(err: String) {

    }

}