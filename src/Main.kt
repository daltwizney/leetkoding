import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    var _minDepth = Int.MAX_VALUE;

    fun _isLeafNode(node: TreeNode?): Boolean {

        if (node == null)
        {
            return false;
        }

        if (node.left != null || node.right != null)
        {
            return false;
        }

        return true;
    }

    fun _minDepthRecursive(root: TreeNode?, currentDepth: Int) {

        if (root == null)
        {
            return;
        }

        if (_isLeafNode(root))
        {
            if (_minDepth > currentDepth)
            {
                _minDepth = currentDepth;
            }
        }

        _minDepthRecursive(root.left, currentDepth + 1);
        _minDepthRecursive(root.right, currentDepth + 1);
    }

    fun minDepth(root: TreeNode?): Int {

        if (root == null)
        {
            return 0;
        }

        _minDepth = Int.MAX_VALUE;

        _minDepthRecursive(root, 1);

        return _minDepth;
    }
}

fun main() {

}
