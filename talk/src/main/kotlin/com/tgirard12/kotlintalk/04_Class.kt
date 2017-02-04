package com.tgirard12.kotlintalk


fun main(args: Array<String>) {

    // NO new to instanciate class
    val kotlin = Kotlin()


    println(Kotlin5("").prop4)
}

// public final by default
class Kotlin

// Primary constructor
class Kotlin1 constructor(feature: String)

// Simpler syntax
class Kotlin2(feature: String)

// Class with body and init => primary constructor cannot contain any code
class Kotlin3(feature: String) {
    init {
        println("feature is : $feature")
    }
}

class Kotlin4(val feature: String) {
    init {
        println("feature is : $feature")
    }

    // Secondary constructor => If primary constructor, call to this mandatory
    // default parameter possible => One constructor required
    // Create with name parameter
    constructor(feature: String, description: String = "") : this(feature)
}

// Refactor one constructor
class Kotlin5(val feature: String, val description: String = "") {

    // Constructor
    // Function => public final
    fun longName() {
        println("$feature - $description")
    }

    // properties Java Style
    // Getter and setter by default
    var prop: String? = null

    // Getter and setter
    // Must be init because getter setter are functions
    var prop1: String? = null
        get() {
            println("get value $prop1")
            return prop1
        }
        set(value) {
            println("set value $value")
            field = value
        }

    // type inference -> Not null
    var prop2 = "my Propertie"

    // Not modifiable, usefulle fo getter
    val prop3 = "my propertie"

    // Init latter or UninitializedPropertyAccessException
    // Usefull for view in Android, test (in before method)
    lateinit var prop4: String
}
