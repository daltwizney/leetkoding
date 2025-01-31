import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun isEmptyCell(cell: Pair<Int, Int>, maze: Array<CharArray>): Boolean {

        return maze[cell.first][cell.second] == '.';
    }

    fun isBorderCell(cell:Pair<Int, Int>, maze: Array<CharArray>): Boolean {

        val rows = maze.size;
        val columns = maze[0].size;

        return (cell.first == 0 && (cell.second >= 0 && cell.second < columns)) &&
                (cell.first == rows - 1 && (cell.second >= 0 && cell.second < columns)) &&
                (cell.second == 0 && (cell.first >= 0 && cell.first < rows)) &&
                (cell.second == columns - 1 && (cell.first >= 0 && cell.first < rows));
    }

    fun isValidCell(cell: Pair<Int, Int>, maze: Array<CharArray>): Boolean {

        val rows = maze.size;
        val columns = maze[0].size;

        return (cell.first >= 0 && cell.first < rows) &&
                (cell.second >= 0 && cell.second < columns);
    }


    fun getNeighbors(cell: Pair<Int, Int>, maze: Array<CharArray>): LinkedList<Int> {

        val top = Pair(cell.first + 1, cell.second);
        val bottom = Pair(cell.first - 1, cell.second);
        val left = Pair(cell.first, cell.second - 1);
        val right = Pair(cell.first, cell.second + 1);

        val neighbors = LinkedList<>
    }

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {


    }
}
