import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap
import java.util.*
import kotlin.math.max
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun computeMaxDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        val queue: Queue<TreeNode?> = LinkedList();

        queue.add(root);

        var currentDepth = 0;

        var nodesInCurrentLevel = 1;

        while (queue.isNotEmpty())
        {
            currentDepth++;

            var nodesInNextLevel = 0;

            if (nodesInCurrentLevel <= 0)
            {
                throw RuntimeException("queue is not empty, but we counted nodes in this level still!");
            }

            for (i in 0..nodesInCurrentLevel - 1)
            {
                var node = queue.remove();

                if (node?.left != null)
                {
                    queue.add(node.left);

                    nodesInNextLevel++;
                }

                if (node?.right != null)
                {
                    queue.add(node.right);

                    nodesInNextLevel++;
                }
            }

            nodesInCurrentLevel = nodesInNextLevel;
        }

        return currentDepth;
    }

    fun deepestLeavesSum(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        val maxDepth = computeMaxDepth(root);

        val queue: Queue<TreeNode?> = LinkedList();

        queue.add(root);

        var currentDepth = 0;

        var nodesInCurrentLevel = 1;

        var sum = 0;

        while (queue.isNotEmpty())
        {
            currentDepth++;
            var nodesInNextLevel = 0;

            for (i in 0..nodesInCurrentLevel - 1)
            {
                var node = queue.remove();

                if (currentDepth == maxDepth)
                {
                    sum += node?.`val` ?: 0;
                }

                if (node?.left != null)
                {
                    queue.add(node.left);
                    nodesInNextLevel++;
                }

                if (node?.right != null)
                {
                    queue.add(node.right);
                    nodesInNextLevel++;
                }
            }

            nodesInCurrentLevel = nodesInNextLevel;
        }

        return sum;
    }
}

fun main() {

    println("hello leetkoding!");
}