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

    private var root : Node;

    init {

        this.root = Node();
    }

    fun insert(value : Int) : Boolean {

        var newNode : Node? = Node(value);

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

    fun printTree() {

        var stack : ArrayDeque<Node?> = ArrayDeque<Node?>();

        if (this.root.left != null)
        {
            stack.addLast(this.root.left);
        }

        if (this.root.right != null)
        {
            stack.addLast(this.root.right);
        }

        while (!stack.isEmpty())
        {
            var node = stack.removeLast();

            println("value = ${node?.value}");

            if (node?.left != null)
            {
                stack.addLast(node.left);
            }

            if (node?.right != null)
            {
                stack.addLast(node.right);
            }
        }
    }
}