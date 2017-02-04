package com.tgirard12.kotlintalk

// data keyword
// One field required

// Automaticaly generate equal(), hashCode(), toString()
data class DataClass(val name: String)


fun main(args: Array<String>) {

    val dataClass1 = DataClass("1")
    println(dataClass1)     // Default to string

    val dataClass2 = dataClass1.copy(name = "2")
    println(dataClass1 == dataClass2)       // Equals
}