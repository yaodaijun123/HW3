import org.example.MinHeap

interface MinPriorityQueue<T> {

    fun isEmpty(): Boolean

    fun addWithPriority(elem: T, priority: Double)

    fun next(): T?

    fun adjustPriority(elem: T, newPriority: Double)
}

/**
 * A minimum priority queue implemented using MinHeap.
 *
 * Elements with lower priority values are removed before elements with higher priority values.
 *
 * @param T the type of elements stored in the queue
 */
class MyMinPriorityQueue<T> : MinPriorityQueue<T> {

    private val heap = MinHeap<T>()

    override fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    override fun addWithPriority(elem: T, priority: Double) {
        heap.insert(elem, priority)
    }

    override fun next(): T? {
        return heap.getMin()
    }

    override fun adjustPriority(elem: T, newPriority: Double) {
        heap.adjustHeapNumber(elem, newPriority)
    }
}