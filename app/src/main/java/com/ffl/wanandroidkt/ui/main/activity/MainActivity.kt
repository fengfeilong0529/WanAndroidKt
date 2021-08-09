package com.ffl.wanandroidkt.ui.main.activity

import android.util.Log
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseActivity
import com.ffl.wanandroidkt.ui.main.adapter.HomeVpAdapter
import com.ffl.wanandroidkt.ui.main.fragment.ArchitectureFragment
import com.ffl.wanandroidkt.ui.main.fragment.HomeFragment
import com.ffl.wanandroidkt.ui.main.fragment.MyFragment
import com.ffl.wanandroidkt.ui.main.fragment.QAFragment
import com.ffl.wanandroidkt.ui.main.presenter.MainPresenter
import com.ffl.wanandroidkt.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView, ViewPager.OnPageChangeListener,
    RadioGroup.OnCheckedChangeListener {

    private var mFragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        rbtnHome.setOnClickListener {
            getPresenter()!!.test("我是测试数据！")
        }
        mFragments.add(HomeFragment())
        mFragments.add(ArchitectureFragment())
        mFragments.add(QAFragment())
        mFragments.add(MyFragment())
        var adapter = HomeVpAdapter(supportFragmentManager, mFragments)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(this)
        rg_tab_bar.setOnCheckedChangeListener(this)
    }

    override fun initData() {
        getPresenter()!!.getHomeArticleList()
    }

    override fun createPresenter(): MainPresenter? = MainPresenter()

    override fun <T> setData(data: T) {
//        Log.e("FFL", "-----------$data")

    }

    override fun setError(err: String) {
        Log.e("FFL", "出错了-----------$err")
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
    }

    override fun onPageScrollStateChanged(state: Int) {
        if (state == 2) {
            if (viewPager.currentItem == 0) {
                rbtnHome.isChecked = true
            } else if (viewPager.currentItem == 1) {
                rbtnArchitecture.isChecked = true
            } else if (viewPager.currentItem == 2) {
                rbtnNavigation.isChecked = true
            } else if (viewPager.currentItem == 3) {
                rbtnMy.isChecked = true
            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        if (p1 == R.id.rbtnHome) {
            viewPager.currentItem = 0
        } else if (p1 == R.id.rbtnArchitecture) {
            viewPager.currentItem = 1
        } else if (p1 == R.id.rbtnNavigation) {
            viewPager.currentItem = 2
        } else if (p1 == R.id.rbtnMy) {
            viewPager.currentItem = 3
        }
    }

}
