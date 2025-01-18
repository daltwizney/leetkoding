import java.util.*
import kotlin.collections.ArrayDeque

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null)
        {
            return listOf();
        }

        var zig = true;

        var result = mutableListOf<List<Int>>();

        val deque = ArrayDeque<TreeNode?>();

        deque.addLast(root);

        var currentLevelNodeCount = 1;
        var nextLevelNodeCount = 0;

        while (deque.isNotEmpty())
        {
            var currentLevelList = LinkedList<Int>();

            for (i in 0..currentLevelNodeCount - 1)
            {
                val node = deque.removeFirst();

                if (node == null)
                {
                    continue;
                }

                if (zig)
                {
                    currentLevelList.addLast(node.`val`);
                }
                else // zag
                {
                    currentLevelList.addFirst(node.`val`);
                }

                if (node.left != null)
                {
                    deque.addLast(node.left);
                    nextLevelNodeCount++;
                }

                if (node.right != null)
                {
                    deque.addLast(node.right);
                    nextLevelNodeCount++;
                }
            }

            result.add(currentLevelList);

            currentLevelNodeCount = nextLevelNodeCount;
            nextLevelNodeCount = 0;

            zig = !zig;
        }

        return result;
    }
}
