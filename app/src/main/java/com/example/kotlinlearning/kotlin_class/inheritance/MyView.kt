package com.example.kotlinlearning.kotlin_class.inheritance

import android.content.Context
import android.util.AttributeSet


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Derived, v 0.1 25/03/20 16.05 by Abraham Ginting
 */

//The base class must be initialize using parameters of the primary constructor if there are existing
class MyView : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context)
}