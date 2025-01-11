import com.wizneylabs.leetcoding.MaxHeap

class MaxHeapTests {
    fun testRemove(heap : MaxHeap) {

        val maxValue = heap.remove();

        println("max value = ${maxValue}");
    }

    fun maxHeapTest() {

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

}