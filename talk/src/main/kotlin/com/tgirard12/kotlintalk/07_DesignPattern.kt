package com.tgirard12.kotlintalk


// v1 -> Java version
interface StringFormatter {
    fun formatString(string: String): String
}

class UpperCaseFormatter : StringFormatter {
    override fun formatString(string: String): String = string.toUpperCase()
}

class LowerCaseFormatter : StringFormatter {
    override fun formatString(string: String): String = string.toLowerCase()
}

class Printer(val strategy: StringFormatter) {
    fun printString(string: String) = println(strategy.formatString(string))
}

// v2
class Printer2(val strategy: (String) -> String) {
    fun printString(string: String) = println(strategy.invoke(string))
}

val lowerCaseFormatter: (String) -> String = String::toLowerCase

val upperCaseFormatter = { it: String -> it.toUpperCase() }


fun main(args: Array<String>) {
    val lowerCasePrinter = Printer(LowerCaseFormatter())
    lowerCasePrinter.printString("LOREM ipsum DOLOR sit amet")

    val upperCasePrinter = Printer(UpperCaseFormatter())
    upperCasePrinter.printString("LOREM ipsum DOLOR sit amet")

    // v2
    val lowerCasePrinter2 = Printer2(lowerCaseFormatter)
    lowerCasePrinter2.printString("LOREM ipsum DOLOR sit amet")

    val upperCasePrinter2 = Printer2(upperCaseFormatter)
    upperCasePrinter2.printString("LOREM ipsum DOLOR sit amet")
}
