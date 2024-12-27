import com.wizneylabs.leetcoding.BinarySearchTree

class BSTTests {

    init {

    }

    fun test1() {

        var bst : BinarySearchTree = BinarySearchTree();

        bst.insert(2);
        bst.insert(7);
        bst.insert(100);
        bst.insert(42);
        bst.insert(23);
        bst.insert(69);
        bst.insert(124);
        bst.insert(0);
        bst.insert(-10);
        bst.insert(-42);
        bst.insert(-8);
        bst.insert(-9);
        bst.insert(-4);

        bst.printTreeRecursive();
    }

    fun run() {

        this.test1();
    }
}