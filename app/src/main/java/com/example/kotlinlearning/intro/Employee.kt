package com.example.kotlinlearning.intro


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Employee, v 0.1 2020-03-10 14:42 by Abraham Ginting
 */
//Expresiveness
//Data class auto-generate all the fields and property accessors, as well as some useful methods
//such as toString(), getEquals(), and hashCode()
data class Employee (

    var id: String,

    var age: Int = 0,

    var firstName: String = "",

    var lastName: String = "",

    var address: String = ""

) {
    fun print(): String {
        return super.toString()
    }
}