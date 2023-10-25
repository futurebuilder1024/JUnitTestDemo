package com.example.junittest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val count = Count()
        val result = count.add(2, 2)
        assertEquals(result, 2 + 2)
    }
}

internal class Count {
    fun add(x: Int, y: Int): Int {
        return x + y
    }
}