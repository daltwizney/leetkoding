package playground

import com.wizneylabs.kollie.pathfinding.Maze
import com.wizneylabs.kollie.pathfinding.PathfinderBase
import org.joml.Vector2i
import java.util.*

class PathfinderGreedyBFSPractice(maze: Maze): PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i): List<Vector2i> {

        // don't forget to populate _exploredNodes and _frontierNodes
        // instead of creating your own, so they will get drawn too!
        _exploredNodes.clear();
        _frontierNodes.clear();

        // min heap where pairs consist of maze indices for key, manhattan distance to endPoint as value
        val frontierNodesQueue = PriorityQueue<Pair<Vector2i, Int>> { a, b -> a.second.compareTo(b.second) };

        // note we're going to update the _frontierNodes any time we modify the frontierNodesQueue
        frontierNodesQueue.add(Pair(startPoint, manhattanDistance(startPoint, endPoint)));
        _frontierNodes.add(startPoint);

        val parents = hashMapOf<Vector2i, Vector2i>();

        while (frontierNodesQueue.isNotEmpty())
        {
            val cell = frontierNodesQueue.first().first;

            if (cell == endPoint)
            {
                break;
            }

            frontierNodesQueue.remove();
            _frontierNodes.remove(cell);

            _exploredNodes.add(cell);

            val neighbors = this.getWalkableNeighbors(cell);

            for (i in 0..neighbors.size - 1)
            {
                val neighbor = neighbors[i];

                if (!_frontierNodes.contains(neighbor) && !_exploredNodes.contains(neighbor))
                {
                    frontierNodesQueue.add(Pair(neighbor, manhattanDistance(neighbor, endPoint)));
                    _frontierNodes.add(neighbor);

                    parents[neighbor] = cell;
                }
            }
        }

        // reconstruct the path
        val path = LinkedList<Vector2i>();

        var currentNode = endPoint;

        while (!parents.contains(currentNode))
        {
            path.add(currentNode);

            currentNode = parents[currentNode]!!;
        }

        return path;
    }
}