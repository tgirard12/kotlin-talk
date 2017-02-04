package com.tgirard12.kotlintalk

import android.view.View

// Object expression : Beter anonymous inner classes

object Singleton {

    val name = "Singleton"

}

// Singleton depuis une interface ou une class
object Singleton2 : View.OnClickListener {
    override fun onClick(v: View?) {
        println("View.onClick")
    }
}

open class Part1(val code: String)
interface Part2

fun main(args: Array<String>) {

    println(Singleton.name)

    // Singleton 2
    println(Singleton2.onClick(null))

    // Part1 et part 2
    // Create just un object to encapsule some results
    // Same synthax for the inner classes
    val obj = object : Part1("o"), Part2 {
        val second = "s"
    }
    println(obj.javaClass)

    val gps = object {
        val lat = 10.3
        val long = 5.7
    }
    println("${gps.lat}, ${gps.long}")
}