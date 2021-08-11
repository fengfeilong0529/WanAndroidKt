package com.ffl.wanandroidkt.ui.main.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseFragment
import com.ffl.wanandroidkt.ui.main.activity.WebActivity
import com.ffl.wanandroidkt.ui.main.adapter.HomeRvAdapter
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.ui.main.presenter.MainPresenter
import com.ffl.wanandroidkt.ui.main.view.MainView
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import kotlinx.android.synthetic.main.fragment_home.*
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
                val title = mAdapter.data[position].title as String
                val link = mAdapter.data[position].link as String
                WebActivity.startActivity(activity!!, title, link)
            }
        })
    }

    override fun initData() {
        getPresenter()!!.getHomeArticleList()
        getPresenter()!!.getHomeBanner()
    }

    override fun <T> setData(data: T) {
    }

    override fun <T> setMainData(data: T, code: Int) {
        super.setMainData(data, code)
        if (code == 101) {
            if (data is MainModel) {
                mAdapter.setNewData(data.datas as MutableList<MainModel.DatasBean>?)
            }
        } else if (code == 102) {
//            Log.e("FFL", "=====轮播图=====$data")
            showToast("haha")
            val list = data as List<BannerModel>
            vpBanner.addBannerLifecycleObserver(this)
                .setAdapter(object : BannerImageAdapter<BannerModel>(list) {
                    override fun onBindView(holder: BannerImageHolder?, data: BannerModel?, position: Int, size: Int) {
                        Glide.with(holder!!.itemView).load(data!!.imagePath).into(holder.imageView)
                    }
                })
                .setIndicator(CircleIndicator(activity))
                .setOnBannerListener(object : OnBannerListener<BannerModel> {
                    override fun OnBannerClick(data: BannerModel?, position: Int) {
                        val title = data!!.title as String
                        val url = data!!.url as String
                        WebActivity.startActivity(activity!!, title, url)
                    }
                })
        }
    }

    override fun setError(err: String) {
        Log.e("FFL", "=====ERROR=====$err")
        showToast(err)
    }


    private fun openWeb(title: String, url: String) {
        Intent(activity, WebActivity::class.java).run {
            putExtra("title", title)
            putExtra("url", url)
            startActivity(this)
        }
    }

}