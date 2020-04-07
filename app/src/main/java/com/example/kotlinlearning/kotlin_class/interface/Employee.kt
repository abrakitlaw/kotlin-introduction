package com.example.kotlinlearning.kotlin_class.`interface`


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Employee, v 0.1 25/03/20 22.04 by Abraham Ginting
 */
class Employee(
    override val firstName: String,
    override val lastName: String
) : Person {

    override fun saveName() {
        println("Your name $name is saved")
    }
}

fun main(args: Array<String>) {
    Employee("Abra", "Ginting").saveName()
}