package com.tgirard12.kotlintalk

import com.chibatching.kotpref.KotprefModel

object Prefs : KotprefModel() {

    var search: String by stringPrefVar("")

}