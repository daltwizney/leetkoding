import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() = runBlocking {

    val mazeHeight = 50;
    val mazeWidth = 50;

    val horizontalWalks = 10;
    val verticalWalks = 10;

    val maze = Maze(mazeWidth, mazeHeight);
    maze.generateDrunkenCrawl(horizontalWalks, verticalWalks);

    val renderer = MazeRenderer(maze);

    renderer.draw();
}