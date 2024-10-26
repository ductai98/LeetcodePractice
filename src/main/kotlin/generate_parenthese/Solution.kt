package org.example.generate_parenthese

import java.util.Stack

fun main() {
    val solution = Solution()
    solution.generateParenthesis(3).forEach {
        println(it.toString())
    }
}

private class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val chars = charArrayOf('(', ')')
        fun backtrack(current: ArrayDeque<Char>) {
            if (current.size == n*2) {
                val str = current.joinToString(separator = "")
                if (validParenthesis(str)) {
                    result.add(str)
                }
                return
            }

            for (char in chars) {
                if (current.size < n*2) {
                    current.add(char)
                    backtrack(current)
                    current.removeLast()
                }
            }
        }

        backtrack(ArrayDeque<Char>())

        return result
    }

    fun validParenthesis(s: String): Boolean{
        val stack = Stack<Char>()
        if (s.length == 1) return false
        for (i in 0 until s.length) {
            if (s[i] == '(') {
                stack.add('(')
                continue
            }
            if (s[i] == ')') {
                if (stack.isEmpty()) return false
                if (stack.pop() != '(') {
                    return false
                }
            }
        }
        if (stack.isNotEmpty()) {
            return false
        }
        return true
    }
}
