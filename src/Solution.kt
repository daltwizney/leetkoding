import java.util.*

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    private fun _validPathRecursive(root: Int, visited: HashSet<Int>, graph: HashMap<Int, LinkedList<Int>>, destination: Int): Boolean {

        if (root == destination)
        {
            return true;
        }

        if (visited.contains(root))
        {
            return false;
        }

        visited.add(root);

        val hasChildren = graph.containsKey(root);

        var children: LinkedList<Int>? = null;

        if (!hasChildren)
        {
            return false;
        }

        children = graph[root];

        if (children!!.size == 0)
        {
            return false;
        }

        for (i in 0..children!!.size - 1) {

            val child = children[i];

            if (!visited.contains(child))
            {
                val foundPath = _validPathRecursive(child, visited, graph, destination);

                if (foundPath) {
                    return true;
                }
            }
        }

        return false;
    }

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

        if (n == 0)
        {
            return false;
        }
        else if (source == destination)
        {
            return true;
        }

        // build adjacency list
        val graph = hashMapOf<Int, LinkedList<Int>>();

        for (i in 0..edges.size - 1)
        {
            val edge = edges[i];

            val a = edge[0];
            val b = edge[1];

            if (!graph.containsKey(a))
            {
                graph[a] = LinkedList<Int>();
            }

            if (!graph.containsKey(b))
            {
                graph[b] = LinkedList<Int>();
            }

            graph[a]!!.add(b);
            graph[b]!!.add(a);
        }

        if (!graph.containsKey(source) || !graph.containsKey(destination))
        {
            return false;
        }

        // do DFS search to check if path exists
        val visited = hashSetOf<Int>();
        return _validPathRecursive(source, visited, graph, destination);
    }
}
