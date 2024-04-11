fun main() {

    /*** Lambda basics: ***/
    // If lambdas are functions without names, then how do you use them?:
    // To use a lambda, you first have to assign it to a variable or constant, including as an argument to another function.

    var multiplyLambda: (Int, Int) -> Int
    multiplyLambda = { a: Int, b: Int ->
        Int
        a * b
    }

    val lambdaResult = multiplyLambda(4, 2)
    /*** Note:
     * Although Lambdas are functions(without names), but it doesn't support the use of name arguments;
     * for instance, you con't write:
     *      multiplyLambda(a = 4, b = 2).
     * Unlike functions, you can't use the parameter names for labelling the arguments.
     */


    /*** Shorthand syntax ***/
    // Do you know that Lambdas are functions that are designed to be lightweight.

    // 1. The use of Kotlin's type inference to shorten the syntax by removing the data type information:
    multiplyLambda = { a, b ->
        a * b
    }

    // 2. The use of the 'it' keyword:
    "For a lambda that has only one parameter, you can shorten it even further using the 'it keyword' "
    var doubleLambda = { a: Int ->
        2 * a
    }

    doubleLambda = { 2 * it }
    val square: (Int) -> Int = { it * it }


    /*** Lambdas as arguments ***/

    fun operateOnNumbers(
        a: Int,
        b: Int,
        operation: (Int, Int) -> Int
    ): Int   {
        val result = operation(a, b)
        println(result)
        return result
    }


    val addLambda = { a: Int, b: Int ->
        a + b
    }
    operateOnNumbers(4, 2, operation = addLambda)


    fun addFunction(a: Int, c: Int) = a + c

    // Since the operation parameter in the operateOnNumbers() is a lambda you can pass in function as the argument as so:
    val resultOfOperation = operateOnNumbers(4, 2, operation = ::addFunction)
    println("The operation result is: $resultOfOperation")

    // You can define the lambda inline with the operateOnNumbers function call, like this:
    operateOnNumbers(4, 2, operation = { a: Int, b: Int ->
        a + b
    })

    operateOnNumbers(4, 2, operation = fun (a: Int, b: Int) = a - b)
    // Did you see what I did above, this is the actual function with no names lol 😁

    // You can reduce the above like
    operateOnNumbers(4, 2, operation = fun (a, b) = a - b)

    operateOnNumbers(4, 2, { a, b ->
        a + b
    })

    "The + operator is just an operator function plus() in the Int class that takes two arguments and returns one result" +
            "so you can write:"

    operateOnNumbers(4, 2, operation = Int::plus)

    """ Another way to simplify the syntax, but this only works if the lambda is the final argument passed to a function: """
    operateOnNumbers(4, 2) { a, b ->
        a + b
    }


    /*** Lambdas with no meaningful return value ***/
    var unitLambda: () -> Unit = {
        println("Kotlin Apprentice is awesome!")
    }
    unitLambda()

    // If you literally want the lambda to not return a value, must use the Nothing type, like so:
    var nothingLambda: () -> Nothing = {
        throw NullPointerException()
    }

    /*** Capturing from the enclosing scope ***/
    var counter = 0
    val incrementCounter = {
        counter += 1
    }

    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()

    println("counter is now: $counter")


    val counter1 = countingLambda()
    val counter2 = countingLambda()

    println("counter1 = ${counter1()}")
    println("counter2 = ${counter2()}")
    println("counter1 = ${counter1()}")
    println("counter1 = ${counter1()}")
    println("counter2 = ${counter2()}")


    /*** Custom sorting with lambdas ***/
    val names = arrayOf("ZZZZZZ", "BB", "A", "CCCC", "EEEEE")
    names.sorted()

    val namesByLength = names.sortedWith(compareBy {
        -it.length
    })
    println(namesByLength)



    /*** Iterating over collections with lambdas ***/
    // 1. forEach:
    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach {
        println("$it: ${it * it}")
    }

    // 2. filter:
    var prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)
    val largePrices = prices.filter {
        it > 5.0
    }

    // fun <T> Iterable<T>.love(predicate: (T) -> Boolean): List<T>  { }
    println("large Prices = $largePrices")

    """
        Note: The array that is returned from filter (and all of these functions) is a new array. 
        The original is not modified at all.
    """.trimIndent()


    /***
     * Imagine you're having a sale and want to discount all items to 90% of their original price.
     * There's a handy function named map which can achieve this:
     */
    val salePrices = prices.map {
        it * 0.9
    }
    println("90% discounted prices: $salePrices")

    // I can use forEach function to achieve the same thing:
    val discountedSalePrices = prices.forEach {
        it * 0.9
    }
    println("discount: $discountedSalePrices")


    // The map lambda/function can also be used to change the type.
    val userInput = listOf("0", "11", "haha", "42")
    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers)

    // To filter out the invalid, null, values, use mapNotNull():
    val numbers2 = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println("numbers2: $numbers2")

    /*** fold function ***/
    var sum = prices.fold(0.0) { a, b ->
        a + b
    }
    println("prices: $prices")
    println("sum of prices: $sum")

    // Using reduce function to achieve the same purpose as fold function:
    sum = prices.reduce { a, b ->
        a + b
    }
    println(sum)

    // Using lambda in maps Like the mapOf() function:
    val stock = mapOf(
        1.5 to 5,
        10.0 to 2,
        4.99 to 20,
        2.30 to 5,
        8.19 to 30
    )
    var stockSum = 0.0
    stock.forEach {
        stockSum += it.key * it.value
    }
    println(stockSum)
}

fun countingLambda(): () -> Int {
    var counter = 0
    val incrementCounter: () -> Int = {
        counter += 1
        counter
    }
    return incrementCounter
}