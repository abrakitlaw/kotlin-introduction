package com.example.kotlinlearning.kotlin_class.abstraction


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version FilledRectangle, v 0.1 25/03/20 17.17 by Abraham Ginting
 */

class FilledRectangle : Rectangle() {
    override fun draw() = println("Drawing Filled Rectangle...")
}

fun main(args: Array<String>) {
    FilledRectangle().draw()
}