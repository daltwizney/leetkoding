import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap

fun testRemove(heap : MaxHeap) {

    val maxValue = heap.remove();

    println("max value = ${maxValue}");
}

fun main() {

    val heap = MaxHeap();

    heap.insert(2);

    heap.insert(42);
    heap.insert(54);

    heap.insert(32);
    heap.insert(23);
    heap.insert(31);
    heap.insert(45);

    testRemove(heap);
    testRemove(heap);

    heap.print();
}
