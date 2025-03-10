package com.wizneylabs.kollie.pathfinding

import org.joml.Vector2i
import kotlin.math.abs

abstract class PathfinderBase(maze: Maze) {

    public val Iterations: Int
        get() = _iterations;

    public val ExploredNodes: List<Vector2i>
        get() = _exploredNodes.toList();

    public val FrontierNodes: List<Vector2i>
        get() = _frontierNodes.toList();

    protected var _iterations = 0;

    protected var _maze = maze;

    // you can update these two sets from each pathfinding implementation
    // for visualization purposes, but not necessary...
    protected val _exploredNodes = hashSetOf<Vector2i>();
    protected val _frontierNodes = hashSetOf<Vector2i>();

    abstract fun computePath(startPoint: Vector2i, endPoint: Vector2i): List<Vector2i>;

    fun manhattanDistance(a: Vector2i, b: Vector2i): Int {

        return abs(a.x - b.x) + abs(a.y - b.y);
    }

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
}