import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        val queue = LinkedList<TreeNode?>();

        queue.addLast(root);

        var currentDepth = 1;

        var nodesInLevel = 1;
        var nodesInNextLevel = 0;

        while (queue.isNotEmpty())
        {
            for (i in 0..nodesInLevel - 1)
            {
                val node = queue.removeFirst();

                if (node == null)
                {
                    continue;
                }

                if (node.left == null && node.right == null)
                {
                    return currentDepth;
                }

                if (node.left != null)
                {
                    queue.addLast(node.left);
                    nodesInNextLevel++;
                }

                if (node.right != null)
                {
                    queue.addLast(node.right);
                    nodesInNextLevel++;
                }
            }

            currentDepth++;
            nodesInLevel = nodesInNextLevel;
            nodesInNextLevel = 0;
        }

        return Int.MAX_VALUE;
    }
}
