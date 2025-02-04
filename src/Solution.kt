import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun middleNode(head: ListNode?): ListNode? {

        if (head == null)
        {
            return null;
        }

        if (head.next == null)
        {
            return head;
        }

        var slow = head;
        var fast = head.next;

        while (fast != null)
        {
            slow = slow?.next;

            fast = fast.next;

            if (fast?.next == null)
            {
                break;
            }

            fast = fast.next;
        }

        return slow;
    }
}