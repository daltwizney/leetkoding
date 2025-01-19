import com.wizneylabs.leetcoding.GridRenderer

class MazeRenderer(maze: Maze) {

    private val _maze = maze;

    private val _renderer: GridRenderer;

    init {

        _renderer = GridRenderer(_maze.Height, _maze.Width);
    }

    fun draw() {

        for (i in 0.._maze.Height - 1)
        {
            for (j in 0.._maze.Width - 1)
            {
                val cellValue = _maze.getValue(i, j);

                if (cellValue == 0)
                {
                    _renderer.setCellColor(i, j, GridRenderer.BG_BLACK);
                }
                else if (cellValue == 1)
                {
                    _renderer.setCellColor(i, j, GridRenderer.BG_WHITE);
                }
            }
        }

        _renderer.draw();
    }
}