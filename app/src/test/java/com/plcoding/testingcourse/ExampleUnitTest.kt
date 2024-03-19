package com.plcoding.testingcourse

/**
 * junit5 from this page:
 * https://github.com/mannodermaus/android-junit5
 *
 */


// only for juint4:
// import org.junit.Assert.assertEquals
// import org.junit.Test
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    // This are called only once for all test
    // @BeforeClass
    // @AfterClass

    @BeforeEach
    fun setUp() {

    }
    @AfterEach
    fun tearDown() {

    }

    @Test
    fun addition_isCorrect() {
        // assertEquals(4, 2 + 2)
        assertThat(2+2).isEqualTo(4)

    }
}