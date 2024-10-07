package org.example.basic_calculator

import kotlin.collections.ArrayDeque

fun main() {
    val str = "3-2+20+(2-3-4+1)+((1+20)-(3-2))"
    val solution = Solution()
    val result = solution.calculate(str)
    println(result)
}

private class Solution {
    fun calculate(s: String): Int {
        val stack = ArrayDeque<Int>()
        var currentNumber = 0
        var result = 0
        var sign = 1 // 1 represents '+', -1 represents '-'

        for (i in s.indices) {
            val char = s[i]

            when {
                char.isDigit() -> {
                    // If the character is a digit, build the current number
                    currentNumber = currentNumber * 10 + (char - '0')
                }
                char == '+' -> {
                    // Add the current number to result and reset currentNumber
                    result += sign * currentNumber
                    currentNumber = 0
                    sign = 1 // Next sign is '+'
                }
                char == '-' -> {
                    result += sign * currentNumber
                    currentNumber = 0
                    sign = -1 // Next sign is '-'
                }
                char == '(' -> {
                    // Push the current result and sign onto the stack, for the new sub-expression
                    stack.add(result)
                    stack.add(sign)
                    result = 0
                    sign = 1
                }
                char == ')' -> {
                    result += sign * currentNumber
                    currentNumber = 0
                    // Pop the sign and result from the stack and apply it to the current result
                    result *= stack.removeLast() // stack.pop() is the sign before the parenthesis
                    result += stack.removeLast() // stack.pop() is the result before the parenthesis
                }
            }
        }

        // In case there is a number left to be added (no more operators)
        result += sign * currentNumber
        return result
    }
}