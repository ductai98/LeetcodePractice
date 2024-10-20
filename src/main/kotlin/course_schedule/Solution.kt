package org.example.course_schedule

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(intArrayOf(1,0))

    val solution = Solution()
    println(solution.canFinish(numCourses, prerequisites))
}

private class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until numCourses) {
            map[i] = mutableListOf()
        }

        prerequisites.forEach { arr ->
            val course = arr[0]
            val dependency = arr[1]
            map[course]?.add(dependency)
        }

        val visited = mutableSetOf<Int>()

        fun dfs(course: Int) : Boolean {
            if (course in visited) return false
            if (map[course].isNullOrEmpty()) return true
            visited.add(course)
            val prerequisite = map[course]
            prerequisite?.forEach {
                if (dfs(it) == false) return false
            }
            visited.remove(course)
            map[course]?.clear()
            return true
        }

        for (i in 0 until numCourses) {
            if (dfs(i) == false) return false
        }

        return true
    }
}