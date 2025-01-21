package com.wizneylabs.kollie.math

class Vector2iTests {

    fun hashTest1() {

        val set = hashSetOf<Vector2i>();

        val a =  Vector2i(2, 3);
        val b = Vector2i(3, 4);
        val c = Vector2i(42, 69);

        set.add(a);
        set.add(b);
        set.add(c);

        println("set count = ${set.count()}");

        println("set contains value = ${set.contains(Vector2i(42, 69))}");
    }

    fun run() {

        this.hashTest1();
    }
}