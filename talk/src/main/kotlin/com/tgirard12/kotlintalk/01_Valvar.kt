package com.tgirard12.kotlintalk


fun main(args: Array<String>) {

    var hello: String? = "Hello"        // var String? -> Java String nullabe
    println(hello)

    hello = "Hello 1"                   // change value
    println(hello)

    var hello1: String = "Hello 2"      // String non nullable
    // var hello1 = null                // Don't compile

    val hello2 = "Hello 2"              // Read Only
    println(hello2)
    // hello2 = "hello 3"               // Don't compile

    val hello3: String? = null          // val null
    println("$hello3")                  // String template

    // val hello3Size = hello3.length           // Don't compile
    val hello3Size = hello3?.length?.div(5)     // null safe operator -> Integer nullable
    println(hello3Size)

    println("helloSize: ${hello3Size ?: 999}")  // Elvis operator

    // String literal
    println("""hello
Android
User
Group
""")

    /*
      Type	  Bit width
      Double  64
      Float	  32
      Long	  64
      Int	  32
      Short	  16
      Byte	  8*/

}