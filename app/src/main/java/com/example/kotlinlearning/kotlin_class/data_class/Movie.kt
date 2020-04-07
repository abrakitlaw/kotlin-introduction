package com.example.kotlinlearning.kotlin_class.data_class


/**
 * @author Abraham Ginting (abraham.ginting@dana.id)
 * @version Movie, v 0.1 26/03/20 00.43 by Abraham Ginting
 */

/**
 * Data class is a class that only contains state and does not perform any operation
 * */
data class Movie(
    val name: String = "",
    val genre: String = ""
)

fun main(args: Array<String>) {

    val movie = Movie("Toy Story", "Animation")
    println(movie.toString())
    println()

    //classes destructuring using componentX functions
    val (name, genre) = movie
    println("Movie name: $name, genre: $genre")
    println()

    //objects copy() need to use when we work with immbutability
    val latestMovie = movie.copy(name = "Coco")
    println(latestMovie.toString())
}