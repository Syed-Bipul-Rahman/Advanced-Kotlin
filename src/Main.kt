/*
@author: Syed Bipul Rahman
 */

fun main() {
    //   println(factorial(10))
    // println(factloop(5))
    // printer(20)

    println(tailFactiorial(5, 1))
}

//factorial with recursive function
//neet much more memory
fun factorial(n: Long): Long {
    return if (n <= 1) {
        1
    } else {
        n * factorial(n - 1)
    }

}

//factorial using loop best approach
//enhance uses less memory

fun factloop(n: Long): Long {
    var sum = 1L
    var count = 2
    while (count <= n) {
        sum *= count
        count++
    }
    return sum
}

//Tail recursion- Recursive call is the very last call in a recursive funtion.
//that means nothing is left after the recursive call.
//Tail recursive functions are consider better than non-tail recursive function
//tail recursive can be optimized by the compiler

fun printer(n: Int) {
    if (n <= 0)
        return
    println("number = $n")
    printer(n - 1)

}

//Important Note: not all recursive functions can make tail recursive*

tailrec fun tailFactiorial(n: Long, total: Long): Long {
    val tmp = n * total
    return if (n <= 1) {
        tmp
    } else {
        tailFactiorial(n - 1, tmp)
    }

}

