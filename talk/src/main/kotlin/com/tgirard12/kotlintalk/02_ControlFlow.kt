package com.tgirard12.kotlintalk

import java.util.*


fun main(args: Array<String>) {

    var a = 5
    var b = 10
    var max = a

    if (a < b) max = b  // One line

    // With else
    if (a > b) {
        max = a
    } else {
        max = b
    }

    max = if (a > b) a else b // As expression


    // When switch
    when (a) {
        5, 6 -> println("minus 10")            // two choises
        in 10..20 -> println("ten or more")    // ranges
        else -> println("not found")           // Other change
    }

    val tabs = Arrays.asList(1, 5, 9, 15)

    for (tab in tabs) println(tab)             // For loop on iterator

    for (tab: Int in tabs) {                // Body with a block
        println(tab)
    }

    for ((index, value) in tabs.withIndex()) {   // with indexin a Pair
        println("$index, $value")
    }
}