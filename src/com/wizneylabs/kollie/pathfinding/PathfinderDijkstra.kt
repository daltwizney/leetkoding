package com.wizneylabs.kollie.pathfinding

import org.joml.Vector2i
import java.util.*
import kotlin.collections.ArrayDeque

class PathfinderDijkstra(maze: Maze)
    : PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i)
            : List<Vector2i> {

        // these sets keep track of explored nodes and frontier nodes
        _exploredNodes.clear();
        _frontierNodes.clear();

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

            _exploredNodes.add(cell);
            _frontierNodes.remove(cell);

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

                if (!_exploredNodes.contains(neighbor))
                {
                    if (!_frontierNodes.contains(neighbor))
                    {
                        frontierNodesQueue.addLast(neighbor);
                        _frontierNodes.add(neighbor);

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