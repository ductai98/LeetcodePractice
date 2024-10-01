package org.example.reverse_polish_notation

import java.util.Stack

fun main() {
    val str = arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")
    val solution = Solution()
    val result = solution.evalRPN(str)
    println(result)
}

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (i in 0 until tokens.size) {
            if (tokens[i] in listOf("+", "-", "*", "/")) {
                val operator = tokens[i]
                val num2 = stack.removeLast()
                val num1 = stack.removeLast()
                val result = when (operator) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    else -> num1 / num2
                }
                stack.add(result)
            } else {
                stack.add(tokens[i].toInt())
            }
        }

        return stack.removeLast()
    }
}