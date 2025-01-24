package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.*

class MazeRenderer(maze: Maze) {

    private val _maze = maze;

    private val _renderer: GridRenderer;

    private var _startPoint: Vector2i = Vector2i(-1, -1);
    private var _endPoint: Vector2i = Vector2i(-1, -1);

    private var _path: List<Vector2i> = LinkedList<Vector2i>();
    private var _exploredCells: List<Vector2i> = LinkedList<Vector2i>();
    private var _frontierCells: List<Vector2i> = LinkedList<Vector2i>();

    init {

        _renderer = GridRenderer(_maze.Height, _maze.Width);
    }

    fun setPath(path: List<Vector2i>) {

        this._path = path;
    }

    fun setFrontierCells(cells: List<Vector2i>) {

        this._frontierCells = cells;
    }

    fun setExploredCells(cells: List<Vector2i>) {

        this._exploredCells = cells;
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
                    _renderer.setCellColor(i, j, GridRenderer.BG_WHITE);
                }
            }
        }

        if (_path.size > 0)
        {
            // draw explored nodes
            if (_exploredCells.size > 0)
            {
                for (i in 0.._exploredCells.size - 1)
                {
                    val cell = _exploredCells[i];

                    _renderer.setCellColor(cell.x, cell.y, GridRenderer.BG_BLUE);
                }
            }

            // draw frontier nodes
            if (_frontierCells.size > 0)
            {
                for (i in 0.._frontierCells.size - 1)
                {
                    val cell = _frontierCells[i];

                    _renderer.setCellColor(cell.x, cell.y, GridRenderer.BG_BRIGHT_CYAN);
                }
            }

            // draw path
            for (i in 1.._path.size - 2)
            {
                val cell = _path[i];

                _renderer.setCellColor(cell.x, cell.y, GridRenderer.BG_YELLOW);
            }
        }

        // draw start & end points
        _renderer.setCellColor(_startPoint.x, _startPoint.y, GridRenderer.BG_BRIGHT_GREEN);
        _renderer.setCellColor(_endPoint.x, _endPoint.y, GridRenderer.BG_BRIGHT_RED);

        _renderer.draw();
    }

    fun setStartPoint(value: Vector2i) {

        _startPoint = value;
    }

    fun setEndPoint(value: Vector2i) {

        _endPoint = value;
    }
}