import java.util.*
import kotlin.collections.ArrayDeque

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null)
        {
            return LinkedList<LinkedList<Int>>();
        }

        val queue = ArrayDeque<TreeNode?>();

        queue.add(root);

        var currentLevelNodeCount = 1;
        var nextLevelNodeCount = 0;

        var result = LinkedList<LinkedList<Int>>();

        var zig = true;

        while (queue.isNotEmpty())
        {
            val currentLevelNodes = LinkedList<Int>();

            if (zig)
            {
                for (i in 0..currentLevelNodeCount - 1)
                {
                    val node = queue.removeFirst()!!;

                    currentLevelNodes.addLast(node.`val`);

                    if (node.left != null)
                    {
                        queue.addLast(node.left);
                        nextLevelNodeCount++;
                    }

                    if (node.right != null)
                    {
                        queue.addLast(node.right);
                        nextLevelNodeCount++;
                    }
                }
            }
            else // zag
            {
                for (i in (currentLevelNodeCount - 1) downTo 0)
                {
                    val node = queue.removeLast()!!;

                    currentLevelNodes.addLast(node.`val`);

                    if (node.right != null)
                    {
                        queue.addFirst(node.right);
                        nextLevelNodeCount++;
                    }

                    if (node.left != null)
                    {
                        queue.addFirst(node.left);
                        nextLevelNodeCount++;
                    }
                }
            }

            zig = !zig;

            currentLevelNodeCount = nextLevelNodeCount;
            nextLevelNodeCount =  0;

            result.addLast(currentLevelNodes);
        }

        return result;
    }
}