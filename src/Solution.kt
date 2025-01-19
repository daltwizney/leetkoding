import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun _minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return Int.MAX_VALUE;
        }

        val leftChildMinDepth = _minDepth(root.left);
        val rightChildMinDepth = _minDepth(root.right);

        if (leftChildMinDepth == Int.MAX_VALUE &&
            rightChildMinDepth == Int.MAX_VALUE)
        {
            return 1;
        }

        return min(leftChildMinDepth, rightChildMinDepth) + 1;
    }

    fun minDepth(root: TreeNode?): Int {

        val result = _minDepth(root);

        if (result == Int.MAX_VALUE)
        {
            return 0;
        }

        return result;
    }
}
