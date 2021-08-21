package com.ffl.wanandroidkt.ui.main.fragment

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseFragment
import com.ffl.wanandroidkt.ui.main.activity.WebActivity
import com.ffl.wanandroidkt.ui.main.adapter.HomeRvAdapter
import com.ffl.wanandroidkt.ui.main.model.BannerModel
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.ui.main.presenter.MainPresenter
import com.ffl.wanandroidkt.ui.main.view.MainView
import com.ffl.wanandroidkt.view.HeadView
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.view_home_banner.view.*

class HomeFragment : BaseFragment<MainView, MainPresenter>(), MainView, OnLoadMoreListener {

    private var mHomeList = mutableListOf<MainModel.DatasBean>()
    private var mAdapter = HomeRvAdapter(R.layout.item_home_rv, mHomeList)
    private var mRvHome: RecyclerView? = null
    private var mPageIndex = 0
    private var mVpBanner: Banner<*, *>? = null

    override fun createPresenter() = MainPresenter()

    override fun getLayoutId() = R.layout.fragment_home

    override fun initView(view: View) {
        mRvHome = view.findViewById(R.id.rvHome)
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
        mAdapter.loadMoreModule.setOnLoadMoreListener(this)
        val headerView = LayoutInflater.from(activity).inflate(R.layout.view_home_banner, null)
        if (mAdapter.hasHeaderLayout()) return
        mVpBanner = headerView.vpBanner
        mAdapter.addHeaderView(headerView)

        view.headView.setOnHeadClickListener(object :HeadView.HeadClickListener{
            override fun onClickBack() {
                showToast("left")
            }

            override fun onClickTitle() {
                //点击标题返回列表顶部
                mRvHome!!.smoothScrollToPosition(0)
            }

            override fun onClickMore() {
                //跳转到搜索界面

            }
        })
    }

    override fun initData() {
        showProgressDialog()
        getPresenter()?.getHomeTopArticles()

        mAdapter.data.clear()
        mPageIndex = 0
        loadArticleList()
        getPresenter()?.getHomeBanner()
    }

    private fun loadArticleList() {
        getPresenter()?.getHomeArticleList(mPageIndex)
    }

    override fun <T> setData(data: T) {
    }

    override fun <T> setMainData(data: T, code: Int) {
        super.setMainData(data, code)
        if (code == 101) {
            hideProgressDialog()
            if (data is MainModel) {
                mPageIndex++
                if (mPageIndex == 1) {
                    if (mAdapter.data.isEmpty()) {
                        mAdapter.setNewData(data.datas as MutableList<MainModel.DatasBean>)
                    } else {
                        mAdapter.addData(data.datas as MutableList<MainModel.DatasBean>)
                    }
                } else {
                    mAdapter.addData(data.datas as MutableList<MainModel.DatasBean>)
                }
                mAdapter.loadMoreModule.isEnableLoadMore = data.curPage != data.pageCount
                mAdapter.loadMoreModule.loadMoreComplete()
            }
        } else if (code == 102) {
//            Log.e("FFL", "=====轮播图=====$data")
            val list = data as List<BannerModel>
            mVpBanner!!.addBannerLifecycleObserver(this)
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
        } else if (code == 103) {
            val list = data as List<MainModel.DatasBean>
            Log.e("FFL", "置顶文章数量=${list.size}")
            for (item in list) {
                item.top = true
            }
            if (mAdapter.data.isEmpty()) {
                mAdapter.setNewData(data as MutableList<MainModel.DatasBean>)
            } else {
                var listNew = mutableListOf<MainModel.DatasBean>()
                listNew.addAll(list)
                mAdapter.setNewData(listNew)
            }
        }
    }

    override fun setError(err: String) {
        Log.e("FFL", "=====ERROR=====$err")
        showToast(err)
    }

    override fun onLoadMore() {
        loadArticleList()
    }

    private fun openWeb(title: String, url: String) {
        Intent(activity, WebActivity::class.java).run {
            putExtra("title", title)
            putExtra("url", url)
            startActivity(this)
        }
    }

}