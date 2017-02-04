package com.tgirard12.kotlintalk


fun main(args: Array<String>) {

    // empty list
    val mutableList0 = mutableListOf<String>()
    println(mutableList0)

    // mutable
    val mutableList = mutableListOf("a", "b")
    println(mutableList)

    mutableList.add("c")
    mutableList += "d"        // Operator overloading http://kotlinlang.org/docs/reference/operator-overloading.html
    println(mutableList)

    // create a read only list
    val readOnly = listOf("D", "E")
    println(readOnly)
    println(readOnly[0])

    // readOnly.add // no add method

    // Question
    // Type check cast : like instance of
    println(readOnly is kotlin.collections.List<*>)
    println(readOnly is kotlin.collections.MutableList)
    println(readOnly is java.util.List<*>)

    println(mutableList is kotlin.collections.List<*>)
    println(mutableList is kotlin.collections.MutableList)
    println(mutableList is java.util.List<*>)

    // Map
    println(hashMapOf(1 to "one"))

    // operation on list
    println(
            readOnly.filter { it == "D" }
                    .count())

    println(readOnly.sumBy { it.length })
}