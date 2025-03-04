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

    fun findWinners(matches: Array<IntArray>): List<List<Int>> {

        val lossCounts = hashMapOf<Int, Int>();

        for (i in 0..matches.size - 1)
        {
            val match = matches[i];
            val winner = match[0];
            val loser = match[1];

            if (!lossCounts.containsKey(winner))
            {
                lossCounts[winner] = 0;
            }

            if (!lossCounts.containsKey(loser))
            {
                lossCounts[loser] = 0;
            }

            lossCounts[loser] = lossCounts[loser]!! + 1;
        }

        val noLosses = mutableListOf<Int>();
        val oneLoss = mutableListOf<Int>();

        val players = lossCounts.keys.toList();

        for (i in 0..players.size - 1)
        {
            val player = players[i];

            if (lossCounts[player] == 0)
            {
                noLosses.add(player);
            }
            else if (lossCounts[player] == 1)
            {
                oneLoss.add(player);
            }
        }

        noLosses.sort();
        oneLoss.sort();

        return listOf(noLosses, oneLoss);
    }
}