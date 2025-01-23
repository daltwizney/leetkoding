package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.*
import kotlin.collections.ArrayDeque

private class NodeData(var indices: Vector2i, var distance: Float);

class Pathfinder(maze: Maze) {

    public val Iterations: Int
        get() = _iterations;

    private var _iterations = 0;

    private var _maze = maze;

    fun getWalkableNeighbors(cell: Vector2i): MutableList<Vector2i> {

        val neighbors = mutableListOf<Vector2i>();

        val left = Vector2i(cell.x - 1, cell.y);
        val right = Vector2i(cell.x + 1, cell.y);
        val top = Vector2i(cell.x, cell.y + 1);
        val bottom = Vector2i(cell.x, cell.y - 1);

        if (_maze.isWalkable(left.x, left.y))
        {
            neighbors.add(left);
        }

        if (_maze.isWalkable(right.x, right.y))
        {
            neighbors.add(right);
        }

        if (_maze.isWalkable(top.x, top.y))
        {
            neighbors.add(top);
        }

        if (_maze.isWalkable(bottom.x, bottom.y))
        {
            neighbors.add(bottom);
        }

        return neighbors;
    }

    fun computePathDijkstra(startPoint: Vector2i, endPoint: Vector2i)
        : List<Vector2i> {

        return listOf<Vector2i>();
    }

    fun computePathBFS(startPoint: Vector2i, endPoint: Vector2i)
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