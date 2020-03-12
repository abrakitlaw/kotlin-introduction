package com.example.kotlinlearning


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version NullSafety, v 0.1 2020-03-10 14:49 by Abraham Ginting
 */
class NullSafety {

    //Employee can't be null
    var notNullEmployee: Employee? = null

    //Employee can be null
    private var employee: Employee? = null

    fun printTest(){

        //Won't compile,
        employee.print()

        //will print only if employee != null
        employee?.print()

        //Smart Cast, we don't need to use safe call operator if we previously checked nullity
        if (employee != null) {
            employee.print()
        }

        //Use only we are sure it's not null. will throw an exception otherwise
        employee!!.print()

        //Use Elvis operator to give an alternative in case the object is null
        val name = employee?.firstName ?: ""
    }
}