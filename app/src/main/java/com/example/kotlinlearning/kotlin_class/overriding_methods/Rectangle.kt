package com.example.kotlinlearning.kotlin_class.overriding_methods


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Circle, v 0.1 25/03/20 16.17 by Abraham Ginting
 */
class Rectangle : Shape() {

    //Declared property can be overriden by initializer or by property with a get method
    override val vertexCount: Int
        get() = 4

    //Overriding methods example
    override fun draw() = println("Drawing Rectangle object...")

    fun removeDraw() = println("Removing Rectangle object...")
}

fun main(args: Array<String>) {
    Shape().draw()
    Shape().fill()
    println()

    val rectangle = Rectangle()
    rectangle.draw()
    rectangle.fill()
    println()

    println("Vertex count total in shape: ${Shape().vertexCount}")
    println("Vertex count total in rectangle: ${Rectangle().vertexCount}")

}