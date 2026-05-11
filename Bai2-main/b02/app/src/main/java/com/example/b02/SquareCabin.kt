package com.example.b02

class SquareCabin(
    residents: Int,
    private val length: Double
) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}
