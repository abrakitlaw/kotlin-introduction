package com.example.kotlinlearning.kotlin_class.overriding_methods


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Shape, v 0.1 25/03/20 16.15 by Abraham Ginting
 */
open class Shape {

    //open keyword so this properties allow to overriding
    open val vertexCount: Int = 0

    //open keyword so this function allow to overriding
    open fun draw() {
        println("Drawing Shape object..")
    }

    fun fill() {
        println("Filling Shape object..")
    }
}