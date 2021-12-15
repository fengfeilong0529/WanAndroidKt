package com.ffl.wanandroidkt.ui.main.model

class BannerModel {

    var title: String? = null
    var imagePath: String? = null
    var desc: String? = null
    var url: String? = null
    var id: Int = 0
    var isVisible: Int = 0
    var order: Int = 0
    var type: Int = 0

    override fun toString(): String {
        return "BannerModel(title=$title, imagePath=$imagePath, desc=$desc, url=$url, id=$id, isVisible=$isVisible, order=$order, type=$type)"
    }

}