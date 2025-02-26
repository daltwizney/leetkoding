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

    private fun _minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return Int.MAX_VALUE;
        }

        val leftChildMinDepth = _minDepth(root.left);
        val rightChildMinDepth = _minDepth(root.right);

        if (leftChildMinDepth == Int.MAX_VALUE &&
            rightChildMinDepth == Int.MAX_VALUE)
        {
            // this is a leaf node
            return 1;
        }

        return min(leftChildMinDepth, rightChildMinDepth) + 1;
    }

    fun minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        return _minDepth(root);
    }
}