package mini_exercises

/***
 * 1. Create a constant list called nameList which contains some names as strings. Any names will do — make sure there’s
 *      more than three. Now use fold to create a string which is the concatenation of each name in the list.
 *
 * 2. Using the same nameList list, first filter the list to contain only names which have more than four characters in
 *      them, and then create the same concatenation of names as in the above exercise.
 *
 * Hint: you can chain these operations together.
 */

fun main() {
    // 1.
    val nameList = listOf("Michael", "Alexandra", "Waugh", "Wade", "Vera", "Stephen", "Judy", "David", "Francis")

    val concatenatedName = nameList.fold("") { a, b ->
        a + b
    }
    println("names: $concatenatedName")

    // 2.
    val fourLetteredNames = nameList.filter { it.length > 4 }.fold("") { a, b ->
        a + b
    }
    println("Names great than 4: $fourLetteredNames")


    // Using reduce to achieve same purpose as fold here:
    val allNames = nameList.reduce { a, b ->
        a + b
    }
    println("allNames: $allNames")
}