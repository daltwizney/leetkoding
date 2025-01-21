package com.wizneylabs.kollie.math

import kotlin.math.abs

class Vector2i {

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
}