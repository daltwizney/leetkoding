package com.wizneylabs.kollie.math

import kotlin.math.abs

class Vector2i {

    companion object {

        fun manhattanDistance(a: Vector2i, b: Vector2i): Int {

            return abs(a.x - b.x) + abs(a.y - b.y);
        }
    }

    var x: Int = 0;
    var y: Int = 0;

    constructor(x: Int, y: Int) {
        this.x = x;
        this.y = y;
    }

    operator fun plus(other: Vector2i) = Vector2i(x + other.x, y + other.y);
    operator fun minus(other: Vector2i) = Vector2i(x - other.x, y - other.y);
    operator fun times(scalar: Int) = Vector2i(x * scalar, y * scalar);

    fun add(other: Vector2i) {

        this.x += other.x;
        this.y += other.y;
    }

    fun subtract(other: Vector2i) {

        this.x -= other.x;
        this.y -= other.y;
    }

    fun scale(value: Int) {

        this.x *= value;
        this.y *= value;
    }

    fun dot(other: Vector2i): Int {

        return this.x * other.x + this.y * other.y;
    }

    override fun equals(other: Any?): Boolean {

        if (other != null && other is Vector2i)
        {
            if (other.x == this.x && other.y == this.y)
            {
                return true;
            }
        }

        return false;
    }

    override fun toString(): String = "($x, $y)";

    override fun hashCode(): Int = Pair<Int, Int>(this.x, this.y).hashCode();
}