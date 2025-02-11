import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        // compute the lengths of each list
        var length1 = 0;
        var length2 = 0;

        var currentNode = l1;

        while (currentNode != null)
        {
            length1++;
            currentNode = currentNode.next;
        }

        currentNode = l2;

        while (currentNode != null)
        {
            length2++;
            currentNode = currentNode.next;
        }

        // compute the sum using the lengths to understand the place value
        var head: ListNode? = ListNode(0);

        val maxLength = max(length1, length2);

        var l1Node = l1;
        var l2Node = l2;

        currentNode = head;

        var carryOne = false;

        for (i in 0..maxLength - 1)
        {
            var value1 = 0;
            var value2 = 0;

            if (i < length1)
            {
                value1 = l1Node!!.`val`;
                l1Node = l1Node.next;
            }

            if (i < length2)
            {
                value2 = l2Node!!.`val`;
                l2Node = l2Node.next;
            }

            var sum = value1 + value2;

            if (carryOne)
            {
                sum += 1;
            }

            carryOne = if (sum / 10 == 1) true else false;
            val remainder = sum % 10;

            if (i == 0)
            {
                currentNode!!.`val` = remainder;
            }
            else
            {
                currentNode!!.next = ListNode(remainder);
                currentNode = currentNode.next;
            }
        }

        if (carryOne)
        {
            currentNode!!.next = ListNode(1);
        }

        return head;
    }
}