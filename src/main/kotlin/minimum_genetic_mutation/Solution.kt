package org.example.minimum_genetic_mutation

fun main() {
    val startGene = "AACCGGTT"
    val endGene = "AACCGGTA"
    val bank = arrayOf("AACCGGTA")

    val solution = Solution()
    println(solution.minMutation(startGene, endGene, bank))
}

private class Solution {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val queue = ArrayDeque<Pair<String, Int>>()
        queue.add(startGene to 0)
        val visited = mutableSetOf<String>()
        val genChars = charArrayOf('A', 'C', 'G', 'T')

        while (queue.isNotEmpty()) {
            val pair = queue.removeFirst()
            val currentGen = pair.first
            val mutations = pair.second
            if (currentGen == endGene) return mutations
            for (i in 0 until currentGen.length) {
                val curr = currentGen.toCharArray()
                for (genChar in genChars) {
                    if (genChar == currentGen[i]) continue
                    curr[i] = genChar
                    val mutatedGene = String(curr)

                    if (bank.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                        queue.add(Pair(mutatedGene, mutations + 1))
                        visited.add(mutatedGene)
                    }
                }
            }
        }

        return -1
    }
}