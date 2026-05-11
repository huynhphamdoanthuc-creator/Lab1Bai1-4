package com.example.b02

import kotlin.math.PI

open class RoundHut(
    residents: Int,
    protected val radius: Double
) : Dwelling(residents) {

    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}
