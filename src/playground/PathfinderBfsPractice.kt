package playground

import com.wizneylabs.kollie.pathfinding.Maze
import com.wizneylabs.kollie.pathfinding.PathfinderBase
import org.joml.Vector2i
import java.util.*
import kotlin.collections.ArrayDeque

class PathfinderBfsPractice(maze: Maze): PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i): List<Vector2i> {

        val parents = hashMapOf<Vector2i, Vector2i>();

        val visited = hashSetOf<Vector2i>();

        // do BFS, creating links between nodes
        val queue = ArrayDeque<Vector2i>();

        queue.addLast(startPoint);

        while (queue.isNotEmpty())
        {
            val cell = queue.removeFirst();

            if (cell == endPoint)
            {
                break;
            }

            visited.add(cell);

            val neighbors = this.getWalkableNeighbors(cell);

            for (i in 0..neighbors.size - 1)
            {
                val neighbor = neighbors[i];

                if (!visited.contains(neighbor))
                {
                    visited.add(neighbor);

                    parents[neighbor] = cell;

                    queue.addLast(neighbor);
                }
            }
        }

        // construct path from pointers
        val path = LinkedList<Vector2i>();

        var currentCell = endPoint;

        while (parents.contains(currentCell))
        {
            path.addFirst(currentCell);

            currentCell = parents.get(currentCell)!!;
        }

        path.addFirst(startPoint);

        return path;
    }
}