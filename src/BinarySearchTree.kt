package com.wizneylabs.leetcoding

private class Node(value : Int = -1) {

    var value : Int;
    var left : Node?;
    var right : Node?;

    init {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {

    private var root : Node?;

    init {

        this.root = null;
    }

    fun insert(value : Int) : Boolean {

        var newNode : Node? = Node(value);

        if (this.root == null)
        {
            this.root = newNode;
            return true;
        }

        var stack : ArrayDeque<Node?> = ArrayDeque<Node?>();

        stack.addLast(this.root);

        while (!stack.isEmpty())
        {
            var node : Node? = stack.removeLast();

            if (node != null)
            {
                if (value < node.value)
                {
                    if (node.left != null)
                    {
                        stack.addLast(node.left);
                    }
                    else
                    {
                        node.left = newNode;
                        return true;
                    }
                }
                else if (value > node.value)
                {
                    if (node.right != null)
                    {
                        stack.addLast(node.right);
                    }
                    else
                    {
                        node.right = newNode;
                        return true;
                    }
                }
                else // they're equal
                {
                    return false;
                }
            }
        }

        return false;
    }

    private fun _printTreeRecursive(root : Node?) {

        if (root == null)
        {
            return;
        }

        this._printTreeRecursive(root.left);

        println("value = ${root.value}");

        this._printTreeRecursive(root.right);
    }

    fun printTreeRecursive() {

        this._printTreeRecursive(this.root);
    }

    fun printTree() {

        println("TODO: implement this using an interative method");
    }
}