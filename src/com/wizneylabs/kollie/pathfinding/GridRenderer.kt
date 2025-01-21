package com.wizneylabs.kollie.pathfinding

class GridRenderer(rows: Int, cols: Int) {

    companion object {

        val RESET = "\u001B[0m" // resets terminal styles

        // Basic background colors
        val BG_BLACK = "\u001B[40m"
        val BG_RED = "\u001B[41m"
        val BG_GREEN = "\u001B[42m"
        val BG_YELLOW = "\u001B[43m"
        val BG_BLUE = "\u001B[44m"
        val BG_MAGENTA = "\u001B[45m"
        val BG_CYAN = "\u001B[46m"
        val BG_WHITE = "\u001B[47m"

        // Bright/light background colors
        val BG_BRIGHT_BLACK = "\u001B[100m"   // Gray
        val BG_BRIGHT_RED = "\u001B[101m"
        val BG_BRIGHT_GREEN = "\u001B[102m"
        val BG_BRIGHT_YELLOW = "\u001B[103m"
        val BG_BRIGHT_BLUE = "\u001B[104m"
        val BG_BRIGHT_MAGENTA = "\u001B[105m"
        val BG_BRIGHT_CYAN = "\u001B[106m"
        val BG_BRIGHT_WHITE = "\u001B[107m"
    }

    private val _gridData : Array<Array<String>> =
        Array(rows) { Array(cols) { BG_BRIGHT_BLACK } };

    private val _rows = rows;
    private val _cols = cols;

    fun draw() {

        // top row
        for (i in 0..this._rows + 1)
        {
            print("$BG_BLACK   $RESET");
        }

        println("");

        for (i in 0..this._rows - 1)
        {
            print("$BG_BLACK   $RESET");

            for (j in 0..this._cols - 1)
            {
                val cellColor = this._gridData[i][j];

                print("${cellColor}   $RESET");
            }

            print("$BG_BLACK   $RESET");
            println("");
        }

        // bottom row
        for (i in 0..this._rows + 1)
        {
            print("$BG_BLACK   $RESET");
        }
    }

    fun setCellColor(row: Int, col: Int, color: String) {

        this._gridData[row][col] = color;
    }

}