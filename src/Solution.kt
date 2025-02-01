import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun makeGood(s: String): String {

        val stack = ArrayDeque<Char>();

        stack.addLast(s[0]);

        for (i in 1..s.length - 1) {

            val c = s[i];

            if (stack.isEmpty())
            {
                stack.addLast(c);
                continue;
            }

            val prev = stack.last();

            if ((prev.lowercaseChar() == c.lowercaseChar()) &&
                ((prev.isUpperCase() && c.isLowerCase()) || (prev.isLowerCase() && c.isUpperCase())))
            {
                // drop the two letters
                stack.removeLast();
            }
            else
            {
                stack.addLast(c);
            }
        }

        var builder = StringBuilder();

        while (!stack.isEmpty())
        {
            builder.append(stack.removeFirst());
        }

        return builder.toString();
    }
}
