package org.example.basic_calculator

import kotlin.collections.ArrayDeque

fun main() {
    val str = "2-4-(8+2-6+(8+4-(1)+8-10))"
    val solution = Solution()
    val result = solution.calculate(str)
    println(result)
}

class Solution {
    fun calculate(s: String): Int {
        val str = "($s)".replace(" ","")
        val stack = ArrayDeque<Int>()
        val operatorStack = ArrayDeque<Char>()
        var i = 0
        var currentNum = ""
        var currentOperator = '+'
        var currentResult = 0
        while (i < str.length) {
            val current = str[i]
            if (str[i] !in listOf('(', ')', '+', '-')) {
                currentNum += str[i]
                if (i > 0 && str[i-1] in listOf('+', '-')) {
                    currentOperator = str[i-1]
                }
            } else {
                if (str[i] == '(' && i!= 0) {
                    stack.add(currentResult)
                    if (str[i-1] in listOf('+', '-')) {
                        operatorStack.add(str[i-1])
                    } else {
                        operatorStack.add('+')
                    }
                    currentNum = ""
                    currentResult = 0
                    currentOperator = '+'
                }else if (str[i] == ')') {
                    currentResult = when (currentOperator) {
                        '+' -> (currentResult + (currentNum.toIntOrNull() ?: 0))
                        else -> (currentResult - (currentNum.toIntOrNull() ?: 0))
                    }
                    if (operatorStack.isNotEmpty()) {
                        currentResult = when (operatorStack.removeLast()) {
                            '+'-> stack.removeLast() + currentResult
                            else -> stack.removeLast() - currentResult
                        }
                    }
                    currentNum = ""
                    currentOperator = '+'
                } else if (str[i] in listOf('+', '-')) {
                    currentResult = when (currentOperator) {
                        '+' -> (currentResult + (currentNum.toIntOrNull() ?: 0))
                        else -> (currentResult - (currentNum.toIntOrNull() ?: 0))
                    }
                    currentNum = ""
                }
            }
            i++
        }

        return currentResult
    }
}