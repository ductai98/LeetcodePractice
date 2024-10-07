package org.example.min_stack

import kotlin.math.min

fun main() {
    val minStack = MinStack()
    minStack.push(5)
    minStack.push(4)
    minStack.push(3)
    minStack.push(2)
    minStack.push(1)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.getMin())
}

private class MinStack() {
    val stack = mutableListOf<Int>()
    var minValue = Int.MAX_VALUE
    var preMin = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        if (`val` <= minValue) {
            preMin.add(minValue)
            minValue = `val`
        }
    }

    fun pop() {
        if (stack.removeLast() == minValue) {
            minValue = preMin.removeLast()
        }
    }

    fun top(): Int {
        return stack[stack.size - 1]
    }

    fun getMin(): Int {
        return minValue
    }
}