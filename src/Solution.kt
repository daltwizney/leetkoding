import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun _minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return Int.MAX_VALUE;
        }

        val leftNodeDepth = _minDepth(root.left);
        val rightNodeDepth = _minDepth(root.right);

        if (leftNodeDepth == Int.MAX_VALUE && rightNodeDepth == Int.MAX_VALUE)
        {
            return 1;
        }

        return min(leftNodeDepth, rightNodeDepth) + 1;
    }

    fun minDepth(root: TreeNode?): Int {

        val depth = _minDepth(root);

        if (depth == Int.MAX_VALUE)
        {
            return 0;
        }

        return depth;
    }
}