import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

        fun String.parseInts() = split(" ").map{ it.toInt() }
        val (n ,m) = readLine().parseInts()

        val inDegree = IntArray(n + 1) { 0 }
        val adj = mutableMapOf<Int, MutableList<Int>>()

        repeat(m) {
            val (a, b) = readLine().parseInts()
            adj.computeIfAbsent(a) { mutableListOf() }.add(b)
            inDegree[b]++
        }

        fun topologicalSort(): List<Int> {

            val pq = PriorityQueue<Int>()
            val result = mutableListOf<Int>()

            (1..n)
                .filter { inDegree[it] == 0 }
                .forEach { pq.offer(it) }

            generateSequence { pq.poll() }
                .takeWhile { it != null }
                .forEach { cur ->
                    result.add(cur)
                    adj[cur]?.forEach { next ->
                        inDegree[next]--
                        if(inDegree[next] == 0) pq.offer(next)
                    }
                }

            return result
        }

        topologicalSort()
            .joinToString(" ")
            .let { println(it) }
    }