package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.*
import kotlin.collections.ArrayDeque

class BFSPathfinder(maze: Maze) {

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

    fun computePath(startPoint: Vector2i, endPoint: Vector2i)
        : List<Vector2i>{

        val visited = hashMapOf<Vector2i, Vector2i>();

        val queue = ArrayDeque<Vector2i>();

        queue.addLast(startPoint);

        var pathFound = false;

        while (queue.isNotEmpty())
        {
            val cell = queue.removeFirst();

            if (cell == endPoint)
            {
                pathFound = true;
                break;
            }

            val neighbors = this.getWalkableNeighbors(cell);

            for (i in 0..neighbors.size - 1)
            {
                if (!visited.containsKey(neighbors[i]))
                {
                    queue.addLast(neighbors[i]);

                    visited[neighbors[i]] = cell;
                }
            }
        }

        if (!pathFound)
        {
            return listOf<Vector2i>();
        }

        var path = LinkedList<Vector2i>();

        path.addLast(endPoint);

        var parent = visited[endPoint];

        while (parent != startPoint) {

            path.addFirst(parent!!);

            parent = visited[parent];
        }

        path.addFirst(startPoint);

        return path;
    }
}