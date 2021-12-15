package com.ffl.wanandroidkt.ui.main.activity

import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.ffl.baselib.helper.MMKVHelper
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.base.BaseActivity
import com.ffl.wanandroidkt.base.Constants
import com.ffl.wanandroidkt.ui.main.presenter.SysSettingPresenter
import com.ffl.wanandroidkt.ui.main.view.SysSettingView
import com.ffl.wanandroidkt.view.HeadView
import kotlinx.android.synthetic.main.activity_sys_setting.*

/**
 * 系统设置
 */
class SysSettingActivity : BaseActivity<SysSettingView, SysSettingPresenter>(), SysSettingView {

    override fun getLayoutId(): Int = R.layout.activity_sys_setting

    override fun initView() {
        headView.setOnHeadClickListener(object : HeadView.HeadClickListener {
            override fun onClickBack() {
                finish()
            }

            override fun onClickTitle() {
            }

            override fun onClickMore() {
            }
        })
        swNightMode.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, b: Boolean) {
                if (p0!!.isPressed) {
                    MMKVHelper.getInstance().putBoolean(Constants.KEY_NIGHT_MODE, b)
                    if (b)
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    else
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    window.setWindowAnimations(R.style.WindowAnimationFadeInOut)
                    recreate()
                }
            }
        })
    }

    override fun initData() {
        val nightMode = MMKVHelper.getInstance().getBoolean(Constants.KEY_NIGHT_MODE, false)
        swNightMode.isChecked = nightMode
    }

    override fun createPresenter(): SysSettingPresenter? = SysSettingPresenter()

    override fun <T> setData(data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setError(err: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
