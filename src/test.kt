import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HW3Test {
    @Test
    fun testGraph() {
        val graph = MyGraph<String>()

        graph.addEdge("A", "B", 5.0)
        graph.addEdge("A", "C", 2.0)

        assertEquals(setOf("A", "B", "C"), graph.getVertices())

        assertEquals(
            mapOf("B" to 5.0, "C" to 2.0),
            graph.getEdges("A")
        )
    }
    @Test
    fun testPriorityQueue() {
        val queue = MyMinPriorityQueue<String>()

        queue.addWithPriority("A", 10.0)
        queue.addWithPriority("B", 3.0)
        queue.addWithPriority("C", 7.0)

        assertEquals("B", queue.next())
        assertEquals("C", queue.next())
        assertEquals("A", queue.next())
        assertTrue(queue.isEmpty())
    }
    @Test
    fun testDijkstraShortestPath() {
        val graph = MyGraph<String>()

        graph.addEdge("A", "B", 10.0)
        graph.addEdge("A", "C", 2.0)
        graph.addEdge("C", "D", 1.0)
        graph.addEdge("D", "B", 3.0)

        val path = dijkstra(graph, "A", "B")

        assertEquals(
            listOf("A", "C", "D", "B"),
            path
        )
    }
}