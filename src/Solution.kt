import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun _swapChars(s: CharArray, index1: Int, index2: Int) {

        val temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }

    fun reverseString(s: CharArray): Unit {

        for (i in 0..(s.size - 1) / 2)
        {
            val index1 = i;
            val index2 = s.size - i - 1;

            _swapChars(s, index1, index2);
        }
    }
}