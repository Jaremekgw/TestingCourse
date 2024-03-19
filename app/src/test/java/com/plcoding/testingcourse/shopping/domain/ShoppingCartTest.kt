package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class ShoppingCartTest {
    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp() {
        // create instance
        cart = ShoppingCart()
    }

    // name: What that test doing,  What we expect
    // instead of:  fun addMultipleProducts_totalPriceSumCorrect()
    @Test
    fun `Add multiple products, total price sum is correct`() {
        val product = Product (
            id = 0,
            name = "Ice cream",
            price = 5.5
        )
        cart.addProduct(product = product, 4)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertThat(priceSum).isEqualTo(22.0)
    }

    @Test
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
}