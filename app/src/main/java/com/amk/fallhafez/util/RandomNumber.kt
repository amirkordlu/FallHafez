package com.amk.fallhafez.util

class RandomNumber(private val from: Int, private val to: Int) {
    fun nextInt(): Int {
        return (from..to).shuffled().last()
    }
}