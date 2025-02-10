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

        val queue = ArrayDeque<TreeNode>();

        queue.addLast(root);

        var currentDepth = 1;
        var nodesInCurrentDepth = 1;
        var nodesInNextLevel = 0;

        var minDepth = Int.MAX_VALUE;

        while (queue.isNotEmpty())
        {
            for (i in 0..nodesInCurrentDepth - 1)
            {
                val node = queue.removeFirst();

                if (node.left != null)
                {
                    queue.addLast(node.left!!);
                    nodesInNextLevel++;
                }

                if (node.right != null)
                {
                    queue.addLast(node.right!!);
                    nodesInNextLevel++;
                }

                if (node.left == null && node.right == null)
                {
                    // it's a leaf node
                    if (currentDepth < minDepth)
                    {
                        minDepth = currentDepth;
                    }
                }
            }

            nodesInCurrentDepth = nodesInNextLevel;
            nodesInNextLevel = 0;
            currentDepth++;
        }

        return minDepth;
    }
}