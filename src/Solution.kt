import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

        // build graph as adjacency list
        val graph = hashMapOf<Int, HashSet<Int>>();

        for (i in 0..edges.size - 1)
        {
            val node0 = edges[i][0];
            val node1 = edges[i][1];

            if (!graph.containsKey(node0))
            {
                graph[node0] = hashSetOf<Int>();
            }

            if (!graph.containsKey(node1))
            {
                graph[node1] = hashSetOf<Int>();
            }

            graph[node0]!!.add(node1);
            graph[node1]!!.add(node0);
        }

        // search for path in graph using BFS
        val queue = ArrayDeque<Int>();

        val visited = hashSetOf<Int>();

        queue.addLast(source);

        visited.add(source);

        while (queue.isNotEmpty())
        {
            val node = queue.removeFirst();

            if (node == destination)
            {
                return true;
            }

            val neighbors = graph[node]!!;

            for (neighbor in neighbors)
            {
                if (!visited.contains(neighbor))
                {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }
}