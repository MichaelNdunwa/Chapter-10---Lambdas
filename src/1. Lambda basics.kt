

fun main() {
    // Since Lambdas are functions without name you can use them by assigning them to a variable or constant and as an
    // argument to another function.

    // Here is a declaration of a variable that can hold a lambda:
    var multiplyLambda: (Int , Int) -> Int  // Lambda declaration:
    multiplyLambda = { a: Int, b: Int -> Int    // Initializing
        a * b
    }
    val lambdaResult = multiplyLambda(4, 2)
    println("multiplyLambda(4, 2) = ${multiplyLambda(4, 2)}")
}