package org.example

fun main() {
    var result = 0
    val arr = mutableListOf<Int>(0,1)

    for (i in 2..10) {
        result = arr[i-1] + arr[i-2]
        arr.add(result)
    }
    println(result)
}