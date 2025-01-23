package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i

class PathfinderDijkstra(maze: Maze)
    : PathfinderBase(maze) {

    override fun computePath(startPoint: Vector2i, endPoint: Vector2i)
            : List<Vector2i> {

        return listOf<Vector2i>();
    }
}