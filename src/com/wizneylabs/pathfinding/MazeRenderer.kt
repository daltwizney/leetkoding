package com.wizneylabs.pathfinding

class MazeRenderer(maze: Maze) {

    private val _maze = maze;

    private val _renderer: GridRenderer;

    private var _startPoint: Pair<Int, Int> = Pair(-1, -1);
    private var _endPoint: Pair<Int, Int> = Pair(-1, -1);

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
                    if (i == _startPoint.first && j == _startPoint.second)
                    {
                        _renderer.setCellColor(i, j, GridRenderer.BG_BRIGHT_GREEN);
                    }
                    else if (i == _endPoint.first && j == _endPoint.second)
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

    fun setStartPoint(value: Pair<Int, Int>) {

        _startPoint = value;
    }

    fun setEndPoint(value: Pair<Int, Int>) {

        _endPoint = value;
    }
}