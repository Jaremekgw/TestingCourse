package com.plcoding.testingcourse.shopping.domain

import androidx.core.app.RemoteInput.Source
import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class ShoppingCartTest {
    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp() {
        // create instance
        cart = ShoppingCart()
    }

    // name: What that test doing,  What we expect
    // instead of:  fun addMultipleProducts_totalPriceSumCorrect()
    // @Test
    @ParameterizedTest
    @CsvSource(
        "3,16.5",
        "0,0.0",
        "10,55.0",
        "4,22.0",
        "20,110.0"
    )
    fun `Add multiple products, total price sum is correct`(
        quantity: Int,
        expectedPrice: Double
    ) {
        val product = Product (
            id = 0,
            name = "Ice cream",
            price = 5.5
        )
        cart.addProduct(product = product, quantity)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertThat(priceSum).isEqualTo(expectedPrice)
    }

    @RepeatedTest(50)
    fun `Add product with negative quantity, throws Exception`() {
        val product = Product (
            id = 0,
            name = "Ice cream",
            price = 5.5
        )

        assertFailure {
            cart.addProduct(product = product, -1)
        }
    }

    @Test
    fun `isValidProduct returns invalid for not existing product`() {
        val product = Product (
            id = 134,
            name = "Ice cream",
            price = 5.5
        )

        cart.addProduct(product = product, 4)
        assertThat(cart.getTotalCost()).isEqualTo(0.0)

    }
}