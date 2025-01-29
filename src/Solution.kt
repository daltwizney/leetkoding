import java.util.*

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class Solution {

    fun isValidCell(cell: Pair<Int, Int>, gridWidth: Int, gridHeight: Int): Boolean {

        return cell.first >= 0 && cell.first < gridHeight
                && cell.second >= 0 && cell.second < gridWidth;
    }

    fun getNeighbors(cell: Pair<Int, Int>, gridWidth: Int, gridHeight: Int):
            List<Pair<Int, Int>> {

        val topNeighbor = Pair(cell.first + 1, cell.second);
        val bottomNeighbor = Pair(cell.first - 1, cell.second);
        val leftNeighbor = Pair(cell.first, cell.second - 1);
        val rightNeighbor = Pair(cell.first, cell.second + 1);

        val neighbors = LinkedList<Pair<Int, Int>>();

        if (isValidCell(topNeighbor, gridWidth, gridHeight))
        {
            neighbors.add(topNeighbor);
        }

        if (isValidCell(bottomNeighbor, gridWidth, gridHeight))
        {
            neighbors.add(bottomNeighbor);
        }

        if (isValidCell(leftNeighbor, gridWidth, gridHeight))
        {
            neighbors.add(leftNeighbor);
        }

        if (isValidCell(rightNeighbor, gridWidth, gridHeight))
        {
            neighbors.add(rightNeighbor);
        }

        return neighbors;
    }

    fun computeIslandArea(root: Pair<Int, Int>, grid: Array<IntArray>,
                          visited: HashSet<Pair<Int, Int>>): Int {

        val gridHeight = grid.size;
        val gridWidth = grid[0].size;

        val queue = ArrayDeque<Pair<Int, Int>>();

        queue.add(root);

        var area = 0;

        while (queue.isNotEmpty())
        {
            val cell = queue.removeFirst();

            area++;
            visited.add(cell);

            val neighbors = getNeighbors(cell, gridWidth, gridHeight);

            neighbors.forEach({ n ->

                if (grid[n.first][n.second] == 1 && !visited.contains(n))
                {
                    queue.add(n);
                    visited.add(n);
                }
            })
        }

        return area;
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        if (grid.size == 0 || grid[0].size == 0)
        {
            return 0;
        }

        val gridHeight = grid.size;
        val gridWidth = grid[0].size;

        var maxArea = 0;

        val visited = hashSetOf<Pair<Int, Int>>();

        for (i in 0..gridHeight - 1)
        {
            for (j in 0..gridWidth - 1)
            {
                val cell = Pair(i, j);

                if (grid[i][j] == 1 && !visited.contains(cell))
                {
                    val currentIslandArea = computeIslandArea(cell, grid, visited);

                    if (currentIslandArea > maxArea)
                    {
                        maxArea = currentIslandArea;
                    }
                }
            }
        }

        return maxArea;
    }
}
