package com.wizneylabs.leetcoding

import kotlin.math.floor

class MaxHeap {

    private val data : ArrayList<Int> = ArrayList<Int>();

    init {}

    fun parentIndex(childIndex : Int) : Int {

        val index = floor((childIndex - 1) / 2.0f).toInt();

        if (index < 0 || index > this.data.size - 1)
        {
            return Int.MIN_VALUE;
        }

        return index;
    }

    fun leftChildIndex(parentIndex : Int) : Int {

        val index = (parentIndex * 2) + 1;

        if (index < 0 || index > this.data.size - 1)
        {
            return Int.MIN_VALUE;
        }

        return index;
    }

    fun rightChildIndex(parentIndex : Int) : Int {

        val index = (parentIndex * 2) + 2;

        if (index < 0 || index > this.data.size - 1)
        {
            return Int.MIN_VALUE;
        }

        return index;
    }

    fun value(index : Int) : Int {

        if (index < 0 || index > this.data.size - 1)
        {
            return Int.MIN_VALUE;
        }

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

    private fun _sinkDown(index : Int) {

        val nodeValue = this.data[index];
        var currentIndex = index;

        while (true) {

            var leftChild = this.leftChildIndex(currentIndex);
            var rightChild = this.rightChildIndex(currentIndex);

            var leftChildValue = this.value(leftChild);
            var rightChildValue = this.value(rightChild);

            var maxIndex = currentIndex;

            if (leftChildValue > this.value(maxIndex))
            {
                maxIndex = leftChild;
            }

            if (rightChildValue > this.value(maxIndex))
            {
                maxIndex = rightChild;
            }

            if (maxIndex != currentIndex)
            {
                this._swap(currentIndex, maxIndex);
                currentIndex = maxIndex;
            }
            else
            {
                return;
            }
        }
    }

    fun remove() : Int {

        if (this.data.size == 0)
        {
            return Int.MIN_VALUE;
        }

        val maxValue = this.data[0];

        this.data[0] = this.data.removeLast();

        this._sinkDown(0); // restore heap property

        return maxValue;
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