package com.tgirard12.kotlintalk

// Strategy
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

fun main(args: Array<String>) {
    val lowerCasePrinter = Printer(LowerCaseFormatter())
    lowerCasePrinter.printString("LOREM ipsum DOLOR sit amet")

    val upperCasePrinter = Printer(UpperCaseFormatter())
    upperCasePrinter.printString("LOREM ipsum DOLOR sit amet")
}
