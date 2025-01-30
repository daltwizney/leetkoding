import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun deepestLeavesSum(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        val queue = ArrayDeque<TreeNode>();

        queue.add(root);

        var currentLevelNodeCount = 1;
        var nextLevelNodeCount = 0;

        var currentLevelSum = 0;

        while (queue.isNotEmpty())
        {
            currentLevelSum = 0;

            for (i in 0..currentLevelNodeCount - 1)
            {
                val node = queue.removeFirst();

                currentLevelSum += node.`val`;

                if (node.left != null)
                {
                    queue.addLast(node.left!!);
                    nextLevelNodeCount++;
                }

                if (node.right != null)
                {
                    queue.addLast(node.right!!);
                    nextLevelNodeCount++;
                }
            }

            currentLevelNodeCount = nextLevelNodeCount;
            nextLevelNodeCount = 0;
        }

        return currentLevelSum;
    }
}
