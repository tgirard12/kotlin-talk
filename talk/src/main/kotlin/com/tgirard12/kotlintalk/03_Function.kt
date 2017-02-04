package com.tgirard12.kotlintalk

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import java.time.LocalTime
import java.util.*


fun main(args: Array<String>) {

    // Can declare function in function -> scope
    // Better solution than private function because parent args are available one child
    fun double(x: Int): Int = x * 2     // Single expression function -> no {} required
    println(double(2))

    // Name param
    println(double(x = 2))

    // type inference
    fun double1(x: Int) = x * 2   // type inference
    println(double1(x = 2))

    // Default Param
    fun doubleDefault(x: Int = 2) = double(x)
    println(doubleDefault(8))

    // Exemple with split function
    println("kotlin".split("t"))

    // Extension function only ToChar()
    fun String.only2Char() = this.substring(0, 2)
    println("kotlin".only2Char())

    // Nullable extension type
    fun String?.only2Char() = this?.substring(0, 2)
    println((null as String?).only2Char())

    // with generic types
    // listof is an extension function
    fun List<String>.countFirst() = this.get(0).length
    println(listOf("a", "bc", "def").countFirst())
    // println(listOf(1, 5).countTotal()) not available for Int

    // Infix for better readability
    // Usefull also for big decimal, assertion
    infix fun Int.hours(minute: Int) = LocalTime.of(this, minute)
    println(5 hours 40)


    //
    // Hight order function
    //
    // A higher-order function is a function that takes functions as parameters, or returns a function
    fun log(f: () -> Unit) {
        println("begin")
        try {
            f()
            println("end")
        } catch (ex: Exception) {
            println("EX ${ex.message}")
        }
    }
    // Execute code
    log({ println("kotlin") })
    log({ throw NullPointerException("null") })


    // Better with database in Android to execute a transaction
    fun SQLiteDatabase.inTx(f: SQLiteDatabase.() -> Unit) {
        this.beginTransaction()
        try {
            f()
            this.setTransactionSuccessful()
        } finally {
            this.endTransaction()
        }
    }

    val db = SQLiteDatabase.openDatabase("", null, 0)
    db.inTx {
        insert("TABLE", null, ContentValues(1))
        update("TABLE", ContentValues(1), "col=?", arrayOf())
    }

    // apply, let, run, with
    // instanciate object with local variable to modify it
    GregorianCalendar().apply {
        timeInMillis = System.currentTimeMillis()
    }

    val str: String? = null
    // not with if (str != null)
    // if only one argument, it's it (like in Groovy)
    // run only if not null
    str?.let { println(it.length) }

    // inline
    // no inline
}
