package org.example
val checked = arrayOf(false, false, false, false)
val arr = Array<Int>(4) {-1}
fun main() {
    println(backtrack(1))
}

fun backtrack(step: Int) {
    if (step > 4) {
        arr.forEach {
            print("$it  ")
        }
        println()
        return
    }
    for (i in 0 until 4) {
        if (!checked[i]) {
            arr[i] = step
            checked[i] = true
            backtrack(step + 1)
            checked[i] = false
        }
    }
}