package com.wizneylabs.leetcoding

import kotlin.math.floor

class MaxHeap {

    private val data : ArrayList<Int> = ArrayList<Int>();

    init {}

    fun parentIndex(childIndex : Int) : Int {

        return floor((childIndex - 1) / 2.0f).toInt();
    }

    fun leftChildIndex(parentIndex : Int) : Int {

        return (parentIndex * 2) + 1;
    }

    fun rightChildIndex(parentIndex : Int) : Int {

        return (parentIndex * 2) + 2;
    }

    fun value(index : Int) : Int {

        return this.data[index];
    }

    private fun _swap(index1 : Int, index2 : Int) {

        val temp = this.data[index1];

        this.data[index1] = this.data[index2];
        this.data[index2] = temp;
    }

    fun insert(value : Int) {

        var index = this.data.size;
        var parentIndex = this.parentIndex(index);

        this.data.add(value);

        if (this.data.size == 1)
        {
            return;
        }

        while (index != 0 && this.data[parentIndex] < this.data[index])
        {
            this._swap(parentIndex, index);

            index = parentIndex;
            parentIndex = this.parentIndex(index);
        }
    }

    fun print() {

        var nodesInLevel = 1;

        var nodesPrintedInLevel = 0;

        for (i in 0..this.data.size - 1)
        {
            val currentNode = this.data[i];

            print("$currentNode    ");

            nodesPrintedInLevel++;

            if (nodesPrintedInLevel == nodesInLevel)
            {
                nodesPrintedInLevel = 0;
                nodesInLevel *= 2;

                println();
            }
        }
    }
}