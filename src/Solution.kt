import java.util.PriorityQueue
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun connectSticks(sticks: IntArray): Int {

        if (sticks.size < 2)
        {
            return 0;
        }

        val minHeap = PriorityQueue<Int>();

        for (i in 0..sticks.size - 1)
        {
            minHeap.add(sticks[i]);
        }

        var totalCost = 0;

        while (minHeap.size > 1)
        {
            val a = minHeap.remove();
            val b = minHeap.remove();

            val c = a + b;

            totalCost += c;

            minHeap.add(c);
        }

        return totalCost;
    }
}