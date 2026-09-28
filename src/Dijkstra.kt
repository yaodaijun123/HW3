/**
 * Finds the shortest path from [start] to [target] using Dijkstra's algorithm.
 *
 * @param graph the weighted directed graph to search
 * @param start the starting vertex
 * @param target the destination vertex
 * @return the shortest path from [start] to [target], or null if no path exists
 */
fun <VertexType> dijkstra(
    graph: Graph<VertexType>,
    start: VertexType,
    target: VertexType
): List<VertexType>? {

    val distances = mutableMapOf<VertexType, Double>()
    val previous = mutableMapOf<VertexType, VertexType>()
    val queue = MyMinPriorityQueue<VertexType>()

    for (vertex in graph.getVertices()) {
        distances[vertex] = Double.POSITIVE_INFINITY
    }

    distances[start] = 0.0
    queue.addWithPriority(start, 0.0)

    while (!queue.isEmpty()) {

        val current = queue.next()!!

        if (current == target) {
            break
        }

        for ((neighbor, cost) in graph.getEdges(current)) {
            // Check whether going through current creates a shorter path
            val newDistance = distances[current]!! + cost

            if (newDistance < distances[neighbor]!!) {
                distances[neighbor] = newDistance
                previous[neighbor] = current

                queue.addWithPriority(neighbor, newDistance)
                queue.adjustPriority(neighbor, newDistance)
            }
        }
    }
    if (start == target) {
        return listOf(start)
    }

    if (!previous.containsKey(target)) {
        return null
    }

    // Reconstruct the path by following previous vertices backward
    val path = mutableListOf<VertexType>()
    var current: VertexType? = target

    while (current != null) {
        path.add(current)

        if (current == start) {
            break
        }

        current = previous[current]
    }

    path.reverse()

    return path
}

fun main() {
    val graph = MyGraph<String>()

    graph.addEdge("A", "B", 10.0)
    graph.addEdge("A", "C", 2.0)
    graph.addEdge("C", "D", 1.0)
    graph.addEdge("D", "B", 3.0)

    println(dijkstra(graph, "A", "B"))
    println(dijkstra(graph, "B", "A"))
    println(dijkstra(graph, "A", "A"))
}