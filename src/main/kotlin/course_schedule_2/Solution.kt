package org.example.course_schedule_2


fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(intArrayOf(1,0))

    val solution = Solution()
    println(solution.findOrder(numCourses, prerequisites).contentToString())
}

private class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val visited = mutableSetOf<Int>()
        val inProgress = mutableSetOf<Int>()
        val result = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            map[i] = mutableListOf()
        }

        prerequisites.forEach { arr ->
            val course = arr[0]
            val dependency = arr[1]
            map[course]?.add(dependency)
        }


        fun dfs(node: Int): Boolean {
            if (node in inProgress) return true

            if (node in visited) return false

            inProgress.add(node)

            for (neighbor in map[node] ?: emptyList()) {
                if (dfs(neighbor)) {
                    return true
                }
            }

            inProgress.remove(node)
            visited.add(node)

            result.add(node)

            return false
        }


        for (i in 0 until numCourses) {
            if (dfs(i)) return intArrayOf()
        }

        return result.toIntArray()
    }
}