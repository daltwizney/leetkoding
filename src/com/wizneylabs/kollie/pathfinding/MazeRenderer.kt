package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i

class MazeRenderer(maze: Maze) {

    private val _maze = maze;

    private val _renderer: GridRenderer;

    private var _startPoint: Vector2i = Vector2i(-1, -1);
    private var _endPoint: Vector2i = Vector2i(-1, -1);

    init {

        _renderer = GridRenderer(_maze.Height, _maze.Width);
    }

    fun draw() {

        for (i in 0.._maze.Height - 1)
        {
            for (j in 0.._maze.Width - 1)
            {
                val cellValue = _maze.getValue(i, j);

                if (cellValue == 0) // wall
                {
                    _renderer.setCellColor(i, j, GridRenderer.BG_BLACK);
                }
                else if (cellValue == 1) // walkable
                {
                    if (i == _startPoint.x && j == _startPoint.y)
                    {
                        _renderer.setCellColor(i, j, GridRenderer.BG_BRIGHT_GREEN);
                    }
                    else if (i == _endPoint.x && j == _endPoint.y)
                    {
                        _renderer.setCellColor(i, j, GridRenderer.BG_BRIGHT_RED);
                    }
                    else
                    {
                        _renderer.setCellColor(i, j, GridRenderer.BG_WHITE);
                    }
                }
            }
        }

        _renderer.draw();
    }

    fun setStartPoint(value: Vector2i) {

        _startPoint = value;
    }

    fun setEndPoint(value: Vector2i) {

        _endPoint = value;
    }
}