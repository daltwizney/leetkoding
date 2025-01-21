class Maze(width: Int, height: Int) {

    private val _width = width;
    private val _height = height;

    val Width: Int
        get() = _width;

    val Height: Int
        get() = _height;

    private val _maze: Array<Array<Int>>;

    init {
        /**
         *  0 = wall cell
         *  1 = walkable cell
         */
        _maze = Array(_height) { Array(_width) { 0 } };
    }

    fun getValue(i: Int, j: Int): Int {

        return _maze[i][j];
    }

    fun generateDrunkenCrawl(horizontalWalks: Int, verticalWalks: Int) {

        for (i in 0..horizontalWalks)
        {
            _doHorizontalDrunkenCrawl();
        }

        for (i in 0..verticalWalks)
        {
            _doVerticalDrunkenCrawl();
        }
    }

    private fun _doHorizontalDrunkenCrawl() {

        throw RuntimeException("fix this - i and j are swapped!");

        var i = 0;
        var j = (0.._height - 1).random();

        while (i < _width)
        {
            _maze[j][i] = 1;

            var deltaJ: Int;

            do {
                deltaJ = (-1..1).random();

            } while (!isValidCell(i, j + deltaJ))

            j += deltaJ;
            i += (0..1).random();
        }
    }

    private fun _doVerticalDrunkenCrawl() {

        throw RuntimeException("fix this - i and j are swapped!");

        var i = (0.._width - 1).random();
        var j = 0;

        while (j < _height)
        {
            _maze[j][i] = 1;

            var deltaI: Int;

            do {
                deltaI = (-1..1).random();

            } while (!isValidCell(i + deltaI, j))

            i += deltaI;
            j += (0..1).random();
        }
    }

    fun isValidCell(i: Int, j: Int): Boolean {

        return i >= 0 && i < _height && j >= 0 && j < _width;
    }

    fun isWalkable(i: Int, j: Int): Boolean {

        return isValidCell(i, j) && _maze[i][j] == 1;
    }
}