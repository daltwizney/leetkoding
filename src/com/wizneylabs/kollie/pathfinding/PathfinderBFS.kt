package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.*
import kotlin.collections.ArrayDeque

private class NodeData(var indices: Vector2i, var distance: Float);

class PathfinderBFS(maze: Maze):
    PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i)
        : List<Vector2i> {

        // these sets keep track of explored nodes and frontier nodes
        val exploredNodes = hashSetOf<Vector2i>();
        val frontierNodesSet = hashSetOf<Vector2i>();

        // this keeps track of all node parents
        val parents = hashMapOf<Vector2i, Vector2i>();

        // this is the queue containing frontier nodes
        val frontierNodesQueue = ArrayDeque<Vector2i>();

        frontierNodesQueue.addLast(startPoint);

        var pathFound = false;
        _iterations = 0;

        while (frontierNodesQueue.isNotEmpty())
        {
            _iterations++;

            val cell = frontierNodesQueue.removeFirst();

            exploredNodes.add(cell);

            if (cell == endPoint)
            {
                pathFound = true;
                break;
            }

            val neighbors = this.getWalkableNeighbors(cell);

            for (i in 0..neighbors.size - 1)
            {
                val neighbor = neighbors[i];

                if (!exploredNodes.contains(neighbor)
                    && !frontierNodesSet.contains((neighbor)))
                {
                    frontierNodesQueue.addLast(neighbor);
                    frontierNodesSet.add(neighbor);

                    parents[neighbor] = cell;
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