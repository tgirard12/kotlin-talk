package com.tgirard12.kotlintalk

import io.kotlintest.matchers.be
import io.kotlintest.specs.StringSpec


/**
 * https://github.com/kotlintest/kotlintest
 */
class KotlinTest : StringSpec() {

    override fun beforeAll() {
        super.beforeAll()
    }

    override fun beforeEach() {
        super.beforeEach()
    }

    init {
        "strings.length should return size of string" {
            "hello".length shouldBe 5
        }

        listOf(3, 5, 7).forEach {
            "$it must be < 10" {
                it should be lt 10
            }
        }
    }
}
