import java.util.*

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun _visitConnectedNodes(root: Int, graph: HashMap<Int, ArrayList<Int>>, visited: HashSet<Int>) {

        val stack = ArrayDeque<Int>();

        stack.addLast(root);

        while (stack.isNotEmpty())
        {
            val node = stack.removeLast();

            visited.add(node);

            if (graph.containsKey(node))
            {
                val siblings = graph[node];

                for (i in 0..siblings!!.size - 1)
                {
                    if (!visited.contains(siblings[i]))
                    {
                        stack.addLast(siblings[i]);
                    }
                }
            }
        }
    }

    fun countComponents(n: Int, edges: Array<IntArray>): Int {

        if (n == 0)
        {
            return 0;
        }
        else if (edges.size == 0)
        {
            return n;
        }

        // build adjacency list
        val graph = hashMapOf<Int, ArrayList<Int>>();

        for (i in 0..edges.size - 1)
        {
            val edge = edges[i];

            val node1 = edge[0];
            val node2 = edge[1];

            if (!graph.containsKey(node1))
            {
                graph[node1] = arrayListOf<Int>();
            }

            if (!graph.containsKey(node2))
            {
                graph[node2] = arrayListOf<Int>();
            }

            graph[node1]!!.add(node2);
            graph[node2]!!.add(node1);
        }

        // iterate through keys of graph and count components
        val visited = hashSetOf<Int>();

        val nodes = graph.keys.toList();

        var connectedComponents = 0;

        for (i in 0..nodes.size - 1)
        {
            val node = nodes[i];

            if (!visited.contains(node))
            {
                _visitConnectedNodes(node, graph, visited);

                connectedComponents++;
            }
        }

        val unvisitedNodeCount = n - visited.size;

        return connectedComponents + unvisitedNodeCount;
    }
}
