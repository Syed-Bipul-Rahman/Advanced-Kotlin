fun main() {
    //   println(factorial(10))

    println(factloop(5))

}

//factorial with recursive function
//neet much more memory
fun factorial(n: Int): Long {
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