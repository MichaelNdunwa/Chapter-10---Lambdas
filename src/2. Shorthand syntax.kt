/***
 * Shorthand syntax:
 *
 *    Lambda syntax can be shortened by two ways:
 *      - Using Kotlin's type inference
 *      - Using it keyword(this only works when the Lambda has one parameter).
 */

fun main() {
    var divideLambda: (Int, Int) -> Int

    // without using Kotlin's type inference:
    divideLambda = { a: Int, b: Int ->
        a / b
    }

    // using Kotlin's type inference:
    divideLambda = { a, b ->
        a / b
    }


    // Declaring a Lambda with single parameter:
    var doubleLambda: (Int) -> Int

    // without using it keyword:
    doubleLambda = { a: Int ->
        2 * a
    }

    // using it keyword:
    doubleLambda = { 2 * it }

}