/**
 * Demonstrates Dijkstra's algorithm using travel costs between cities.
 */
fun main() {
    val cities = MyGraph<String>()

    cities.addEdge("Boston", "New York", 4.0)
    cities.addEdge("Boston", "Philadelphia", 7.0)
    cities.addEdge("New York", "Philadelphia", 2.0)
    cities.addEdge("New York", "Washington DC", 5.0)
    cities.addEdge("Philadelphia", "Washington DC", 2.5)

    val path = dijkstra(
        cities,
        "Boston",
        "Philadelphia"
    )

    println(path)
}