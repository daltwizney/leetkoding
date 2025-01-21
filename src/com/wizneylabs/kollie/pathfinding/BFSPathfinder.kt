package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i

class BFSPathfinder(maze: Maze) {

    fun computePath(startPoint: Vector2i, endPoint: Vector2i)
        : Array<Vector2i>{

        val visited = hashSetOf<Vector2i>();

        val queue = ArrayDeque<Vector2i>();

        queue.addLast(startPoint);

        while (queue.isNotEmpty())
        {

        }


        var path = arrayOf<Vector2i>();

        return path;
    }
}