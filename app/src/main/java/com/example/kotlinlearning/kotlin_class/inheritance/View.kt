package com.example.kotlinlearning.kotlin_class.inheritance

import android.content.Context


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version InheritanceExample, v 0.1 25/03/20 15.58 by Abraham Ginting
 */

/**
 * Kotlin classes have a common superclass *Any*, that has three methods: equals(), hashCode() and toString().
 * Kotlin classes are final by default: not allowed to inherited. Mark with *open* keyword to make it inheritable
 * */
open class View(context: Context) {
}