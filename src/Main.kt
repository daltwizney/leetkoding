import kotlinx.coroutines.runBlocking
import com.wizneylabs.pathfinding.Maze
import com.wizneylabs.pathfinding.MazeRenderer

fun main() = runBlocking {

    val mazeHeight = 50;
    val mazeWidth = 50;

    val horizontalWalks = 12;
    val verticalWalks = 12;

    val maze = Maze(mazeWidth, mazeHeight);
    maze.generateDrunkenCrawl(horizontalWalks, verticalWalks);

    val startPoint = maze.getRandomWalkableCell();
    val endPoint = maze.getRandomWalkableCell();

    val renderer = MazeRenderer(maze);

    renderer.setStartPoint(startPoint);
    renderer.setEndPoint(endPoint);

    renderer.draw();
}