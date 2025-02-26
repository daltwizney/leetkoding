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

    fun minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        val queue = ArrayDeque<TreeNode?>();

        queue.add(root);

        var currentDepth = 1;

        var nodesInCurrentLevel = 1;
        var nodesInNextLevel = 0;

        while (queue.isNotEmpty())
        {
            for (i in 0..nodesInCurrentLevel - 1)
            {
                val node = queue.removeFirst()!!;

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

            nodesInCurrentLevel = nodesInNextLevel;
            nodesInNextLevel = 0;

            currentDepth++;
        }

        return 0;
    }
}