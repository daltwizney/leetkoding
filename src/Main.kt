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



    /**
     *  Min Depth Recursive
     */

    fun _minDepthRecursive(root: TreeNode?): Int {

        if (root == null)
        {
            return Int.MAX_VALUE;
        }

        val leftChildMinDepth = _minDepthRecursive(root.left);
        val rightChildMinDepth = _minDepthRecursive(root.right);

        if (leftChildMinDepth == Int.MAX_VALUE && rightChildMinDepth == Int.MAX_VALUE)
        {
            return 1;
        }

        return min(leftChildMinDepth, rightChildMinDepth) + 1;
    }

    fun minDepth(root: TreeNode?): Int {

        val depth = _minDepthRecursive(root);

        if (depth == Int.MAX_VALUE)
        {
            return 0;
        }

        return depth;
    }
}

fun main() {

    println("hello leetkoding!");
}
