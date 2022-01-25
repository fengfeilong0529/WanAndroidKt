package com.ffl.wanandroidkt.ui.main.model

class LoginModel {

    /**
     * admin : false
     * chapterTops : []
     * coinCount : 0
     * collectIds : [14898,19297,12554,1197,18281,19290,18453,18615,18965,18930]
     * email :
     * icon :
     * id : 81337
     * nickname : fengfeilong
     * password :
     * publicName : fengfeilong
     * token :
     * type : 0
     * username : fengfeilong
     */

    var isAdmin: Boolean = false
    var coinCount: Int = 0
    var email: String? = null
    var icon: String? = null
    var id: Int = 0
    var nickname: String? = null
    var password: String? = null
    var publicName: String? = null
    var token: String? = null
    var type: Int = 0
    var username: String? = null
    var chapterTops: List<*>? = null
    var collectIds: List<Int>? = null

    override fun toString(): String {
        return "LoginModel(isAdmin=$isAdmin, coinCount=$coinCount, email=$email, icon=$icon, id=$id, nickname=$nickname, password=$password, publicName=$publicName, token=$token, type=$type, username=$username, chapterTops=$chapterTops, collectIds=$collectIds)"
    }


}
