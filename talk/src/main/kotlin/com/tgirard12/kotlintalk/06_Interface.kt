package com.tgirard12.kotlintalk


fun main(args: Array<String>) {

    println(Implem("implem").print())

}

interface Base {

    fun print()

    val name: String    // Abstract properties

    val decription: String
        get() = "base"

    val description2 get() = "base2"
}

// Contructor implementation far variable
class Implem(override val name: String) : Base {

    override fun print() {
        print("Implem:$name")
    }
}

// Field with initialization implementation
// Val => assignment required
class Implem2 : Base {
    override val name: String = "Implem2"

    override fun print() {
        print("Implem:$name")
    }

}