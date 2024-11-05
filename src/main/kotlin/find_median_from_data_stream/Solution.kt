package org.example.find_median_from_data_stream

import java.util.PriorityQueue

private class MedianFinder {
    private val lowerHalf = PriorityQueue<Int>(compareByDescending { it })

    private val upperHalf = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.offer(num)
        } else {
            upperHalf.offer(num)
        }

        if (lowerHalf.size > upperHalf.size + 1) {
            upperHalf.offer(lowerHalf.poll())
        } else if (upperHalf.size > lowerHalf.size) {
            lowerHalf.offer(upperHalf.poll())
        }
    }

    fun findMedian(): Double {
        return if (lowerHalf.size > upperHalf.size) {
            lowerHalf.peek().toDouble()
        } else {
            (lowerHalf.peek() + upperHalf.peek()) / 2.0
        }
    }
}