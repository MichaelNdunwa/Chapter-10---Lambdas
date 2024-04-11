package challenges

/***
 * Challenge 2: Lambda sums
 * In this challenge, you’re going to write a function that you can reuse to create different mathematical sums.
 * Declare the function like so:
 * fun mathSum(length: Int, series: (Int) -> Int) -> Int
 *
 * The first parameter, length, defines the number of values to sum. The second parameter, series, is a lambda that can
 * be used to generate a series of values. series should have a parameter that is the position of the value in the series and
 * return the value at that position.
 *
 * mathSum should calculate length number of values, starting at position 1, and return their sum.
 * Use the function to find the sum of the first 10 square numbers, which equals 385.
 * Then use the function to find the sum of the first 10 Fibonacci numbers, which equals 143.
 * For the Fibonacci numbers, you can use the function you wrote in the challenges of the functions chapter — or grab it
 * from the solutions if you’re unsure what you’ve done is correct.
 */

fun main() {
    // Finding the sum of the first 10 square numbers:
    val sumOfSquares = mathSum(10) { it * it}
    println("Sum of the first 10 square numbers: $sumOfSquares")

    // Finding the sum of the first 10 Fibonacci numbers:
    val sumOfFibonacci = mathSum(10, ::fibonacci)
    println("Sum of the first 10 Fibonacci numbers: $sumOfFibonacci")
}

/*fun fibonacci(position: Int): Int {
    val fibonacciSeries = mutableListOf(0, 1)
    (2..10).forEach {
        fibonacciSeries.add(fibonacciSeries[it-2] + fibonacciSeries[it-1])
    }
    return fibonacciSeries[position]
}*/

fun fibonacci(number: Int): Int {
    if (number <= 0) return 0
    if (number == 1  || number == 2) return 1
    return fibonacci(number - 2) + fibonacci(number - 2)
}

fun mathSum(length: Int, series: (Int) -> Int): Int  {
    var sum = 0
    (1..length).forEach { p ->
        sum += series(p)
    }
    return sum
}