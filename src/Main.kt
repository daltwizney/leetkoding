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

    private fun _minDepthRecursive(root: TreeNode?): Int {

        if (root == null)
        {
            return Int.MAX_VALUE;
        }

        val leftChildMinDepth = _minDepthRecursive(root.left);
        val rightChildMinDepth = _minDepthRecursive(root.right);

        val minChildDepth = min(leftChildMinDepth, rightChildMinDepth);

        if (minChildDepth == Int.MAX_VALUE)
        {
            return 1;
        }

        return minChildDepth + 1;
    }

    fun minDepth(root: TreeNode?): Int {

        val result = _minDepthRecursive(root);

        return if (result == Int.MAX_VALUE) 0 else result;
    }

}

fun main() {

    println("hello leetkoding!");
}
