import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun deleteDuplicates(head: ListNode?): ListNode? {

        if (head == null)
        {
            return null;
        }

        if (head.next == null)
        {
            return head;
        }

        var previousNode = head;
        var currentNode = head.next;

        while (currentNode != null)
        {
            if (currentNode.`val` == previousNode?.`val`)
            {
                // remove current node
                previousNode.next = currentNode.next;
                currentNode = previousNode.next;
            }
            else
            {
                previousNode = currentNode;
                currentNode = currentNode?.next;
            }
        }

        return head;
    }
}