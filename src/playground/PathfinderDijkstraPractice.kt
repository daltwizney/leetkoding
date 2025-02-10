package playground

import com.wizneylabs.kollie.pathfinding.Maze
import com.wizneylabs.kollie.pathfinding.PathfinderBase
import org.joml.Vector2i
import java.util.*

class PathfinderDijkstraPractice(maze: Maze): PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i): List<Vector2i> {

        // don't forget to populate _exploredNodes and _frontierNodes
        // instead of creating your own, so they will get drawn too!
        _exploredNodes.clear();
        _frontierNodes.clear();

        val parents = hashMapOf<Vector2i, Vector2i>();

        val queue = PriorityQueue<Pair<Vector2i, Int>> { a, b -> a.second.compareTo(b.second) };

        queue.add(Pair(startPoint, 0));
        _frontierNodes.add(startPoint);

        var reachedEndpoint = false;

        while (queue.isNotEmpty())
        {
            val cellData = queue.remove();

            val cell = cellData.first;
            val cellDistance = cellData.second;

            _frontierNodes.remove(cell);
            _exploredNodes.add(cell);

            if (cell == endPoint)
            {
                reachedEndpoint = true;
                break;
            }

            val neighbors = this.getWalkableNeighbors(cell);

            neighbors.forEach { neighbor ->

                if (!_frontierNodes.contains(neighbor) && !_exploredNodes.contains(neighbor))
                {
                    queue.add(Pair(neighbor, cellDistance + 1));
                    _frontierNodes.add(neighbor);

                    parents[neighbor] = cell;
                }
            };

            _iterations++;
        }

        if (!reachedEndpoint)
        {
            return LinkedList<Vector2i>();
        }

        // construct path
        val path = LinkedList<Vector2i>();

        var currentCell = endPoint;

        while (currentCell != startPoint)
        {
            path.addFirst(currentCell);

            currentCell = parents[currentCell]!!;
        }

        path.addFirst(startPoint);

        return path;
    }
}