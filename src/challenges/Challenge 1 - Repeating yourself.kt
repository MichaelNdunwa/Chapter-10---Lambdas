package challenges

import kotlin.text.Typography.times

/***
 * Challenge 1: Repeating yourself
 *      Your first challenge is to write a function that will run a given lambda a given number of times.
 *      Declare the function like so:
 *           fun repeatTask(times: Int, task: () -> Unit)
 *
 *      The function should run the task lambda times number of times.
 *      Use this function to print "Kotlin Apprentice is a great book!" 10 times.
 */


fun repeatTask(times: Int, task: () -> Unit) {
    repeat(times) { task() }
}

fun main() {
    var times = 1
    repeatTask(10) { println("${times++}. Kotlin Apprentice is a great book!") }
}