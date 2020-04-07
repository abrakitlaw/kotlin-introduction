package com.example.kotlinlearning.kotlin_class.constuctor


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Person, v 0.1 24/03/20 02.22 by Abraham Ginting
 */

/**
 * Class can have a primary constructor and one or more secondary constructor.
 * Omit keyword *constructor* if it doesn't have any annotations or visibility modifiers.
 * */
class PersonConstructorExample (lastname: String) {

    //Initializer blocks are executed in the same order inside the class body
    init {
        println("First initializer block that prints, \"My last name is: $lastname\"")
    }

    init {
        println("Second initializer block that prints, \"My last name length is: ${lastname.length}")
    }

    /**
     * Secondary constructor, if there are primary constructor, we have to delegate each
     * secondary constructor to the primary constructor by using keyword *this()*
     * */
    constructor(firstname: String, lastname: String) : this(lastname) {
        println("Secondary constructor, \"My first name is: $firstname\"")
        println("Secondary constructor, \"My last name is: $lastname\"")
    }

}

fun main(args: Array<String>) {
    //Kotlin doesn't have new keyword to creating instances of classes
    PersonConstructorExample(
        "Abra",
        "Ginting"
    )
}
