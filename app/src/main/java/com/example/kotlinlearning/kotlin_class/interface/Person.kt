package com.example.kotlinlearning.kotlin_class.`interface`


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Person, v 0.1 25/03/20 22.02 by Abraham Ginting
 */
interface Person : Named {

    val firstName: String

    val lastName: String

    override val name: String
        get() = "$firstName $lastName"

    fun saveName()
}