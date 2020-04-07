package com.example.kotlinlearning.kotlin_class.abstraction


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Rectangle, v 0.1 25/03/20 17.14 by Abraham Ginting
 */

/**
 * An abstract member does not have an implementation in its class
 * */
abstract class Rectangle : Polygon() {

    abstract override fun draw()
}