package playground

import com.wizneylabs.kollie.pathfinding.Maze
import com.wizneylabs.kollie.pathfinding.PathfinderBase
import org.joml.Vector2i

class PathfinderConvertDfsToBfsPractice(maze: Maze):
    PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i): List<Vector2i> {

        // these sets keep track of explored nodes and frontier nodes
        _exploredNodes.clear();
        _frontierNodes.clear();

        _iterations = 0;

        // search for path from start to end points
        val parents = hashMapOf<Vector2i, Vector2i>();

        val queue = ArrayDeque<Vector2i>();

        queue.addLast(startPoint);
        _frontierNodes.add(startPoint);

        while (queue.isNotEmpty())
        {
            val node = queue.removeFirst();

            // move node from frontier to explored
            _frontierNodes.remove(node);
            _exploredNodes.add(node);

            if (node == endPoint)
            {
                break;
            }

            // see what neighbors we can add to frontier
            val neighbors = this.getWalkableNeighbors(node);

            for (i in 0..neighbors.size - 1)
            {
                val neighbor = neighbors[i];

                if (!_exploredNodes.contains(neighbor)
                    && !_frontierNodes.contains(neighbor))
                {
                    queue.addLast(neighbor);

                    _frontierNodes.add(neighbor);

                    parents[neighbor] = node;
                }
            }

            _iterations++;
        }

        // build path from node parents found during search
        val path = mutableListOf<Vector2i>();

        var currentNode = endPoint;

        path.add(endPoint);

        while (parents.containsKey(currentNode))
        {
            path.add(parents[currentNode]!!);

            currentNode = parents[currentNode]!!;
        }

        path.add(startPoint);

        return path;
    }
}