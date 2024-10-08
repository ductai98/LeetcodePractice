package org.example

fun main() {
    val arr = arrayOf(1,2,3,4,5,6,7,8,9,10)


    println(binarySearch(arr, 0, 9, 6))
}

fun binarySearch(array: Array<Int>, left: Int, right : Int, value: Int) : Int{
    val mid = (left + right) / 2

    if (left > right) return -1
    if (array[mid] == value) return mid
    if (array[mid] < value) return binarySearch(array, mid + 1, right, value)
    if (array[mid] > value) return binarySearch(array, left, mid, value)
    return -1
}