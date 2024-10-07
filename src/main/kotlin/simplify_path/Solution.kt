package org.example.simplify_path

import java.util.Stack

fun main() {
    val str = "///eHx/.."
    val str2 = "/home/../../.."
    val solution = Solution()
    val result = solution.simplifyPath(str)
    println(result)
}

private class Solution {
    fun simplifyPath(path: String): String {
        var simplePath = path.replace("/+".toRegex(), "/")
        if (simplePath.length > 1 && simplePath.last() == '/') {
            simplePath = simplePath.removeSuffix("/")
        }

        val splited = simplePath.split("/").toMutableList()

        var i = 0
        while (i < splited.size) {
            if (splited.size == 2 && (splited[1] == ".." || splited[1] == ".")) {
                return "/"
            }
            if (splited[i] == ".") {
                splited.removeAt(i)
                i--
            }

            if (splited[i] == ".." && i > 1) {
                splited.removeAt(i-1)
                splited.removeAt(i-1)
                i = i - 2
            }
            if (splited[i] == ".." && i == 1) {
                splited.removeAt(i)
                i = 0
            }


            i++
        }
        simplePath = splited.joinToString("/")
        if (simplePath.isEmpty()) {
            return "/"
        }
        if (simplePath.length > 1 && simplePath.last() == '/') {
            simplePath = simplePath.removeSuffix("/")
        }
        if (simplePath.length > 1 && simplePath.first() != '/') {
            simplePath = "/$simplePath"
        }
        return simplePath
    }
}