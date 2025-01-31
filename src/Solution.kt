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

        return (cell.first == 0 && (cell.second >= 0 && cell.second < columns)) ||
                (cell.first == rows - 1 && (cell.second >= 0 && cell.second < columns)) ||
                (cell.second == 0 && (cell.first >= 0 && cell.first < rows)) ||
                (cell.second == columns - 1 && (cell.first >= 0 && cell.first < rows));
    }

    fun isValidCell(cell: Pair<Int, Int>, maze: Array<CharArray>): Boolean {

        val rows = maze.size;
        val columns = maze[0].size;

        return (cell.first >= 0 && cell.first < rows) &&
                (cell.second >= 0 && cell.second < columns);
    }


    fun getNeighbors(cell: Pair<Int, Int>, maze: Array<CharArray>): LinkedList<Pair<Int, Int>> {

        val top = Pair(cell.first + 1, cell.second);
        val bottom = Pair(cell.first - 1, cell.second);
        val left = Pair(cell.first, cell.second - 1);
        val right = Pair(cell.first, cell.second + 1);

        val neighbors = LinkedList<Pair<Int, Int>>();

        if (isValidCell(top, maze) && isEmptyCell(top, maze))
        {
            neighbors.add(top);
        }

        if (isValidCell(bottom, maze) && isEmptyCell(bottom, maze))
        {
            neighbors.add(bottom);
        }

        if (isValidCell(left, maze) && isEmptyCell(left, maze))
        {
            neighbors.add(left);
        }

        if (isValidCell(right, maze) && isEmptyCell(right, maze))
        {
            neighbors.add(right);
        }

        return neighbors;
    }

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {

        val visited = hashSetOf<Pair<Int, Int>>();
        val distance = hashMapOf<Pair<Int, Int>, Int>();
        val queue = ArrayDeque<Pair<Int, Int>>();

        val root = Pair(entrance[0], entrance[1]);
        distance[root] = 0;

        queue.addLast(root);

        while (queue.isNotEmpty())
        {
            val cell = queue.removeFirst();

            if (cell != root && isBorderCell(cell, maze))
            {
                return distance[cell]!!;
            }

            visited.add(cell);

            val neighbors = getNeighbors(cell, maze);

            neighbors.forEach { neighbor ->

                if (!visited.contains(neighbor))
                {
                    queue.add(neighbor);
                    distance[neighbor] = distance[cell]!! + 1;
                    visited.add(neighbor);
                }
            }
        }

        return -1;
    }
}
