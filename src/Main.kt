import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap
import kotlin.math.max
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun _maxDepthRecursive(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        val leftChildMaxDepth = _maxDepthRecursive(root.left);
        val rightChildMaxDepth = _maxDepthRecursive(root.right);

        var maxChildDepth = max(leftChildMaxDepth, rightChildMaxDepth);

        return maxChildDepth + 1;
    }

    fun maxDepth(root: TreeNode?): Int {

        return _maxDepthRecursive(root);
    }
}

fun main() {

    println("hello leetkoding!");
}
