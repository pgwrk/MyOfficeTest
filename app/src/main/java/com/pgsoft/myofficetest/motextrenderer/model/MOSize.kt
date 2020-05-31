package com.pgsoft.myofficetest.motextrenderer.model

class MOSize(val width: Int, val height: Int)

fun MOSize?.isNullOrZero(): Boolean {
    return when {
        this == null -> false
        width <= 0 || height <= 0 -> false
        else -> true
    }
}