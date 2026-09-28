/**
 * ``Graph`` represents a directed graph
 * @param VertexType the type that represents a vertex in the graph
 */
interface Graph<VertexType> {
    /**
     * @return the vertices in the graph
     */
    fun getVertices(): Set<VertexType>

    /**
     * Add an edge between [from] and [to] with edge weight [cost]
     */
    fun addEdge(from: VertexType, to: VertexType, cost: Double)

    /**
     * Get all the edges that begin at [from]
     * @return a map where each key represents a vertex connected to [from] and the value represents the edge weight.
     */
    fun getEdges(from: VertexType): Map<VertexType, Double>

    /**
     * Remove all edges and vertices from the graph
     */
    fun clear()
}
/**
 * A weighted directed graph implemented using an adjacency list.
 *
 * @param VertexType the type used to represent vertices in the graph
 */
class MyGraph<VertexType> : Graph<VertexType> {

    private val edges:
            MutableMap<VertexType, MutableMap<VertexType, Double>> = mutableMapOf()

    override fun getVertices(): Set<VertexType> {
        return edges.keys
    }

    override fun addEdge(
        from: VertexType,
        to: VertexType,
        cost: Double
    ) {
        if (!edges.containsKey(from)) {
            edges[from] = mutableMapOf()
        }
        if (!edges.containsKey(to)) {
            edges[to] = mutableMapOf()
        }

        edges[from]!![to] = cost
    }

    override fun getEdges(from: VertexType): Map<VertexType, Double> {
        return edges[from] ?: emptyMap()
    }

    override fun clear() {
        edges.clear()
    }
}