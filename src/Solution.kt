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

    fun reverseString(s: CharArray): Unit {

        for (i in 0.. (s.size / 2) - 1)
        {
            val temp = s[i];
            s[i] = s[s.size - 1 - i];
            s[s.size - 1 - i] = temp;
        }
    }
}