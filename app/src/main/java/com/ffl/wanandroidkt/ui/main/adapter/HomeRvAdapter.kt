package com.ffl.wanandroidkt.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ffl.wanandroidkt.R
import com.ffl.wanandroidkt.ui.main.model.MainModel
import com.ffl.wanandroidkt.utils.TimeConvertUtils

class HomeRvAdapter(layoutResId: Int, data: MutableList<MainModel.DatasBean>?) :
    BaseQuickAdapter<MainModel.DatasBean, BaseViewHolder>(layoutResId, data), LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: MainModel.DatasBean) {
        holder.setText(R.id.tvTitle, item.title)
            .setText(R.id.tvContent, item.desc)
            .setText(R.id.tvFrom, item.superChapterName)
            .setText(R.id.tvTime, TimeConvertUtils.longToString(item.publishTime))
            .setText(R.id.tvAuthor, if (item.userId == -1) item.author else item.shareUser)
            .setText(R.id.tvOrder, item.superChapterName + "·" + item.chapterName)
            .setGone(R.id.tvNew, !item.fresh)
            .setGone(R.id.flTop, !item.top)
            .setImageResource(
                R.id.ivCollect,
                if (item.collect) R.drawable.ic_collect_pressed else R.drawable.ic_collect_normal
            )
    }
}