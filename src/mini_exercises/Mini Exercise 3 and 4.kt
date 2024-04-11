package mini_exercises

/***
 * 3. Create a constant map called namesAndAges which contains some names as strings mapped to ages as integers.
 *      Now use filter to create a map containing only people under the age of 18.
 *
 * 4. Using the same namesAndAges map, filter out the adults (those 18 or older) and then use map to convert to a list
 *      containing just the names (i.e., drop the ages).
 */


fun main() {
    /// 3:
    val namesAndAges = mapOf(
        "Michael" to 23,
        "Alexandra" to 21,
        "Waugh" to 56,
        "Wade" to 38,
        "Vera" to 41,
        "Stephen" to 26,
        "Judy" to 14,
        "David" to 23,
        "Francis" to 25
    )

    /*val teenagers = mutableMapOf<String, Int>()
    namesAndAges.forEach { (name, age) ->
        if (age <= 18) teenagers[name] = age
    }*/

    val teenagers = namesAndAges.filter { it.value < 18 }
    println("teenagers: $teenagers")


    /// 4:
    /*val adults = mutableMapOf<String, Int>()
    namesAndAges.forEach { (name, age) ->
        if (age >= 18) adults[name] = age
    }*/


    // There are different ways to catch a fish, this is one of the best approach:
    val adults = namesAndAges.filter { it.value > 18 }
    val namesOfAdults = adults.map { it.key }
    println("namesOfAdults: $namesOfAdults")
}