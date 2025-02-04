import kotlin.math.min

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun maxNumberOfBalloons(text: String): Int {

        // how many of each character we need for the word balloon
        val balloonCharacters = hashMapOf(
            Pair('b', 1),
            Pair('a', 1),
            Pair('l', 2),
            Pair('o', 2),
            Pair('n', 1)
        );

        val balloonKeys = balloonCharacters.keys;

        // build a hashmap containing total count of each character in text
        val wordBank = hashMapOf<Char, Int>();

        for (key in balloonKeys)
        {
            wordBank[key] = 0;
        }

        for (i in 0..text.length - 1)
        {
            val c = text[i];

            if (balloonKeys.contains(c))
            {
                wordBank[c] = wordBank[c]!! + 1;
            }
        }

        // count max number of ballons
        val maxB = wordBank['b']!!;
        val maxA = wordBank['a']!!;

        val maxL = wordBank['l']!! / 2;
        val maxO = wordBank['o']!! / 2;

        val maxN = wordBank['n']!!;

        return min(maxB, min(maxA, min(maxL, min(maxO, maxN))));
    }
}