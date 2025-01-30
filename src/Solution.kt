import java.util.*
import kotlin.math.abs

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun closestValue(root: TreeNode?, target: Double): Int {

        if (root == null)
        {
            return Int.MIN_VALUE;
        }

        val queue = ArrayDeque<TreeNode>();

        queue.add(root);

        var closestVal = Int.MIN_VALUE;
        var minDistance = Double.MAX_VALUE;

        while (queue.isNotEmpty())
        {
            val node = queue.removeLast();

            val distance = abs(node.`val`.toDouble() - target);

            if (distance < minDistance)
            {
                minDistance = distance;
                closestVal = node.`val`;
            }
            else if (distance == minDistance)
            {
                if (node.`val` < closestVal)
                {
                    closestVal = node.`val`;
                }
            }

            if (node.left != null)
            {
                queue.add(node.left!!);
            }

            if (node.right != null)
            {
                queue.add(node.right!!);
            }
        }

        return closestVal;
    }
}
