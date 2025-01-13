import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap
import kotlin.math.max

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun _maxAncestorDiffRecursive(root: TreeNode?): Int {

        if (root == null)
        {
            return Int.MIN_VALUE;
        }

        var leftChildDiff = Int.MIN_VALUE;
        var rightChildDiff = Int.MIN_VALUE;

        val leftNode = root.left;
        val rightNode = root.right;

        if (leftNode != null)
        {
            leftChildDiff = Math.abs(root.`val` - leftNode.`val`);
        }

        if (rightNode != null)
        {
            rightChildDiff = Math.abs(root.`val` - rightNode.`val`);
        }

//        println("visiting tree node: ${root.`val`}, leftChildDiff = ${leftChildDiff}, rightChildDiff = ${rightChildDiff}");

        val leftChildMaxAncestorDiff = _maxAncestorDiffRecursive(leftNode);
        val rightChildMaxAncestorDiff = _maxAncestorDiffRecursive(rightNode);

        println("visiting tree node: ${root.`val`}, leftMaxAncestor = ${leftChildMaxAncestorDiff}, rightMaxAncestor = ${rightChildMaxAncestorDiff}");

        return max(leftChildDiff, max(rightChildDiff,
                max(leftChildMaxAncestorDiff, rightChildMaxAncestorDiff)));
    }

    fun maxAncestorDiff(root: TreeNode?): Int {

        return _maxAncestorDiffRecursive(root);
    }
}

fun main() {

    var root = TreeNode(8);
    root.left = TreeNode(3);
    root.right = TreeNode(10);
    root.left?.left = TreeNode(1);
    root.left?.right = TreeNode(6);
    root.left?.right?.left = TreeNode(4);
    root.left?.right?.right = TreeNode(7);
    root.right?.right = TreeNode(14);
    root.right?.right?.left = TreeNode(13);

    val result = Solution().maxAncestorDiff(root);

    println("result = ${result}");
}
