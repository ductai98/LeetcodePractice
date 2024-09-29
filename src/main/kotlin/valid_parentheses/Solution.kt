package org.example.valid_parentheses

import java.util.Stack

fun main() {
    val str = "(("
    val solution = Solution()
    val result = solution.isValid(str)
    println(result)
}

class Solution {
    //[0,0],[0,0],[4,4],[0,0],[1,3],[5,5],[4,6],[1,1],[0,2]
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        if (s.length == 1) return false
        for (i in 0 until s.length) {
            if (s[i] == '(') {
                stack.add('(')
                continue
            }
            if (s[i] == '{') {
                stack.add('{')
                continue
            }
            if (s[i] == '[') {
                stack.add('[')
                continue
            }

            if (s[i] == ')') {
                if (stack.isEmpty()) return false
                if (stack.pop() != '(') {
                    return false
                }
            }
            if (s[i] == '}') {
                if (stack.isEmpty()) return false
                if (stack.pop() != '{') {
                    return false
                }
            }
            if (s[i] == ']') {
                if (stack.isEmpty()) return false
                if (stack.pop() != '[') {
                    return false
                }
            }
        }
        if (stack.size > 0) {
            return false
        }
        return true
    }
}