package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.*
import kotlin.collections.ArrayDeque

class PathfinderDijkstra(maze: Maze)
    : PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i)
            : List<Vector2i> {

        // these sets keep track of explored nodes and frontier nodes
        val exploredNodes = hashSetOf<Vector2i>();
        val frontierNodesSet = hashSetOf<Vector2i>();

        // this keeps track of all node parents and distances
        val parents = hashMapOf<Vector2i, Vector2i>();

        val distances = hashMapOf<Vector2i, Float>();

        // this is the queue containing frontier nodes
        val frontierNodesQueue = ArrayDeque<Vector2i>();

        frontierNodesQueue.addLast(startPoint);
        distances[startPoint] = 0.0f;

        var pathFound = false;
        _iterations = 0;

        while (frontierNodesQueue.isNotEmpty())
        {
            _iterations++;

            val cell = frontierNodesQueue.removeFirst();

            exploredNodes.add(cell);

            val cellDistance: Float = distances[cell]!!;

            if (cell == endPoint)
            {
                pathFound = true;
                break;
            }

            val neighbors = this.getWalkableNeighbors(cell);

            for (i in 0..neighbors.size - 1)
            {
                val neighbor = neighbors[i];

                if (!exploredNodes.contains(neighbor))
                {
                    if (!frontierNodesSet.contains(neighbor))
                    {
                        frontierNodesQueue.addLast(neighbor);
                        frontierNodesSet.add(neighbor);

                        distances[neighbor] = cellDistance + 1.0f;
                        parents[neighbor] = cell;
                    }
                    else
                    {
                        val newDistance = cellDistance + 1.0f;

                        if (newDistance < distances[neighbor]!!)
                        {
                            distances[neighbor] = newDistance;
                            parents[neighbor] = cell;
                        }
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