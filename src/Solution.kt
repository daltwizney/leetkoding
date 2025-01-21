import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {

        if (root == null)
        {
            return TreeNode(`val`);
        }

        var currentNode = root;

        while (true) {

            if (`val` < currentNode?.`val`!!)
            {
                if (currentNode.left == null)
                {
                    // add to tree
                    currentNode.left = TreeNode(`val`);
                    return root;
                }
                else
                {
                    currentNode = currentNode.left;
                    continue;
                }
            }
            else // `val` > currentNode?.`val`
            {
                if (currentNode.right == null)
                {
                    // add to tree
                    currentNode.right = TreeNode(`val`)
                    return root;
                }
                else
                {
                    currentNode = currentNode.right;
                    continue;
                }
            }
        }
    }
}
