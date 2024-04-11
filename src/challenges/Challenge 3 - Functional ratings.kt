package challenges

/***
 * Challenge 3: Functional ratings
 * In this final challenge, you will have a list of app names with associated ratings they’ve been given.
 * Note — these are all fictional apps!
 * Create the data map like so:
 *      val appRatings = mapOf(
 *          "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
 *          "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
 *          "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
 *      )
 * First, create a map called averageRatings which will contain a mapping of app
 * names to average ratings. Use forEach to iterate through the appRatings map, then
 * use reduce to calculate the average rating and store this rating in the
 * averageRatings map.
 * Finally, use filter and map chained together to get a list of the app names whose
 * average rating is greater than 3.
 */

/*
fun main() {
    val appRatings = mapOf(
        "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
        "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
        "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )

    val averageRatings = appRatings.map { it.key to it.value.average()}
    println(averageRatings)

    val threeStarRating = averageRatings.filter { it.second > 3}.map { it.first}
    println(threeStarRating)
}


fun Array<Int>.average(): Double {
    val sum = this.reduce { a, b ->
        a + b
    }
    return sum / this.size.toDouble()
}*/


/// Using a better approach from chatGPT:
fun main() {
    val appRatings = mapOf(
        "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
        "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
        "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )

    // Calculate average ratings using forEach and reduce
    val averageRatings = mutableMapOf<String, Double>()
    appRatings.forEach { (appName, ratings) ->
        val averageRating = ratings.sum() / ratings.size.toDouble()
        averageRatings[appName] = averageRating
    }
    println("Average Ratings: $averageRatings")

    // Filter apps with average rating greater than 3
    val threeStarRating = averageRatings.filter { it.value > 3 }.keys
    println("Apps with average rating greater than 3: $threeStarRating")
}
