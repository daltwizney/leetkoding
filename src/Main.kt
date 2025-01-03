import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap

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

fun testGridRenderer() {

    val renderer = GridRenderer(15, 15);

    for (i in 1..15 - 2) {

        renderer.setCellColor(1, i, GridRenderer.BG_WHITE);
    }

    for (i in 2..15 - 2) {

        renderer.setCellColor(i, 13, GridRenderer.BG_WHITE);
    }

    renderer.setCellColor(0, 0, GridRenderer.BG_WHITE);
    renderer.setCellColor(0, 1, GridRenderer.BG_WHITE);
    renderer.setCellColor(1, 0, GridRenderer.BG_WHITE);

    renderer.setCellColor(13, 14, GridRenderer.BG_WHITE);
    renderer.setCellColor(14, 14, GridRenderer.BG_WHITE);
    renderer.setCellColor(14, 13, GridRenderer.BG_WHITE);

    renderer.draw();
}

fun main() {

    testGridRenderer();
}
