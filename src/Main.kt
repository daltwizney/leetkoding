import com.wizneylabs.kollie.math.Vector2i
import com.wizneylabs.kollie.math.Vector2iTests
import com.wizneylabs.kollie.pathfinding.BFSPathfinder
import kotlinx.coroutines.runBlocking
import com.wizneylabs.kollie.pathfinding.Maze
import com.wizneylabs.kollie.pathfinding.MazeRenderer

fun mazeTest() {

    val mazeHeight = 50;
    val mazeWidth = 50;

    val horizontalWalks = 12;
    val verticalWalks = 12;

    val maze = Maze(mazeWidth, mazeHeight);
    maze.generateDrunkenCrawl(horizontalWalks, verticalWalks);

    val startPoint = maze.getRandomWalkableCell();
    val endPoint = maze.getRandomWalkableCell();

    val pathfinder = BFSPathfinder(maze);

    val path = pathfinder.computePath(startPoint, endPoint);

    printPath(path);

    val renderer = MazeRenderer(maze);

    renderer.setStartPoint(startPoint);
    renderer.setEndPoint(endPoint);

    renderer.setPath(path);

    renderer.draw();
}

fun printPath(path: List<Vector2i>) {

    println("path = [");

    for (i in 0..path.size - 1) {

        println("\t(${path[i].x}, ${path[i].y})");
    }

    println("]");
}

fun main() = runBlocking {

    mazeTest();
}