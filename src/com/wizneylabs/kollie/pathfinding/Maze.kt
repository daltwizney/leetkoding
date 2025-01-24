package com.wizneylabs.kollie.pathfinding

import com.wizneylabs.kollie.math.Vector2i
import java.util.Vector
import kotlin.random.Random

class Maze(width: Int, height: Int, seed: Long = 0) {

    private val _width = width;
    private val _height = height;

    val Width: Int
        get() = _width;

    val Height: Int
        get() = _height;

    private val _maze: Array<Array<Int>>;

    private var _hasWalkableCells = false;

    private val _random = Random(seed);

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

    fun getRandomWalkableCell(): Vector2i {

        if (!_hasWalkableCells)
        {
            throw RuntimeException("No walkable cells in grid - need to generate a maze first!");
        }

        while (true) {

            val i = _random.nextInt(0, _height);
            val j = _random.nextInt(0, _width);

            if (isWalkable(i, j))
            {
                return Vector2i(i, j);
            }
        }
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

        _hasWalkableCells = true;
    }

    private fun _doHorizontalDrunkenCrawl() {

        var i = _random.nextInt(0, _height);
        var j = 0;

        while (j < _width)
        {
            _maze[i][j] = 1;

            var deltaI: Int;

            do {
                deltaI = _random.nextInt(-1, 2);

            } while (!isValidCell(i + deltaI, j))

            i += deltaI;
            j += _random.nextInt(0, 2);
        }
    }

    private fun _doVerticalDrunkenCrawl() {

        var i = 0;
        var j = _random.nextInt(0, _width);

        while (i < _height)
        {
            _maze[i][j] = 1;

            var deltaJ: Int;

            do {
                deltaJ = _random.nextInt(-1, 2);

            } while (!isValidCell(i, j + deltaJ))

            i += _random.nextInt(0, 2);
            j += deltaJ;
        }
    }

    fun isValidCell(i: Int, j: Int): Boolean {

        return i >= 0 && i < _height && j >= 0 && j < _width;
    }

    fun isWalkable(i: Int, j: Int): Boolean {

        return isValidCell(i, j) && _maze[i][j] == 1;
    }
}