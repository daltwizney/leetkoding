package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.*

class PathfinderGreedyBestFirst(maze: Maze):
    PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i): List<Vector2i> {

        // these sets keep track of explored nodes and frontier nodes
        _exploredNodes.clear();
        _frontierNodes.clear();

        // this keeps track of all node parents and distances
        val parents = hashMapOf<Vector2i, Vector2i>();

        // this is the queue containing frontier nodes
        val frontierNodesQueue = PriorityQueue<Pair<Vector2i, Int>> {
            a, b -> a.second.compareTo(b.second);
        };

        frontierNodesQueue.add(Pair(startPoint, 0));

        var pathFound = false;
        _iterations = 0;

        while (frontierNodesQueue.isNotEmpty())
        {
            _iterations++;

            val cell = frontierNodesQueue.remove().first;

            _exploredNodes.add(cell);

            if (cell == endPoint)
            {
                pathFound = true;
                break;
            }

            val neighbors = this.getWalkableNeighbors(cell);

            for (i in 0..neighbors.size - 1)
            {
                val neighbor = neighbors[i];

                if (!_exploredNodes.contains(neighbor))
                {
                    if (!_frontierNodes.contains(neighbor))
                    {
                        val distance = Vector2i.manhattanDistance(neighbor, endPoint);
                        frontierNodesQueue.add(Pair(neighbor, distance));
                        _frontierNodes.add(neighbor);

                        parents[neighbor] = cell;
                    }
                }
            }
        }

        if (!pathFound)
        {
            return listOf<Vector2i>();
        }

        var path = LinkedList<Vector2i>();

        path.addLast(endPoint);

        var parent = parents[endPoint];

        while (parent != startPoint) {

            path.addFirst(parent!!);

            parent = parents[parent];
        }

        path.addFirst(startPoint);

        return path;
    }
}