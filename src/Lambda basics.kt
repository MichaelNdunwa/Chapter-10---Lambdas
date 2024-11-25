

fun main() {
    // Since Lambdas are function without name you can use them by assigning them to a variable or constant and as an
    // argument to another function.

    // Here is a declaration of a variable that can hold a lambda:
    var multiplyLambda: (Int , Int) -> Int
    multiplyLambda = { a: Int, b: Int -> Int
        a * b
    }
}