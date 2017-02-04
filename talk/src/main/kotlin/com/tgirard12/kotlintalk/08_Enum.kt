package com.tgirard12.kotlintalk


enum class Colors {

    red {
        override fun code() = "R"
    },
    green {
        override fun code(): String = "G"
    },
    blue {
        override fun code(): String = "B"
    };

    // abstract function
    abstract fun code(): String
}


fun main(args: Array<String>) {

    println("${Colors.blue.name} ${Colors.blue.ordinal}")


    val color = Colors.blue

    // When with warning if not all branch are checked
    when (color) {
        Colors.red -> println(color)
        Colors.green -> TODO()
    }

    // Color 2
    println(Colors.red.code())
}