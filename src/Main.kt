import com.wizneylabs.kollie.math.Vector2i
import com.wizneylabs.kollie.pathfinding.*
import kotlinx.coroutines.runBlocking

fun mazeTest() {

    val mazeHeight = 50;
    val mazeWidth = 50;

    val horizontalWalks = 15;
    val verticalWalks = 15;

    val maze = Maze(mazeWidth, mazeHeight);
    maze.generateDrunkenCrawl(horizontalWalks, verticalWalks);

    val startPoint = maze.getRandomWalkableCell();
    val endPoint = maze.getRandomWalkableCell();

    val pathfinder: PathfinderBase = PathfinderBFS(maze);

    val path = pathfinder.computePath(startPoint, endPoint);

    val renderer = MazeRenderer(maze);

    renderer.setStartPoint(startPoint);
    renderer.setEndPoint(endPoint);

    renderer.setPath(path);

    renderer.draw();

    println("path found in ${pathfinder.Iterations} iterations!");
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