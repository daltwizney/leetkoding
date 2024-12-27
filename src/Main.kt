import com.wizneylabs.leetcoding.BinarySearchTree

fun main() {

    var bst : BinarySearchTree = BinarySearchTree();

    bst.insert(2);
    bst.insert(7);
    bst.insert(100);
    bst.insert(42);
    bst.insert(23);
    bst.insert(69);
    bst.insert(42);

    bst.printTreeRecursive();
}