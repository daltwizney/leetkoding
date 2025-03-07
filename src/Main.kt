import org.joml.Vector2i
import com.wizneylabs.kollie.pathfinding.*
import kotlinx.coroutines.runBlocking
import playground.PathfinderBfsPractice
import playground.PathfinderConvertDfsToBfsPractice
import playground.PathfinderDijkstraPractice

import playground.function_types

fun mazeTest() {

    val mazeHeight = 50;
    val mazeWidth = 50;

    val horizontalWalks = 15;
    val verticalWalks = 15;

//    val seed = 42;
    val seed = (0..Long.MAX_VALUE).random();

    val maze = Maze(mazeWidth, mazeHeight, seed);
    maze.generateDrunkenCrawl(horizontalWalks, verticalWalks);

    val startPoint = maze.getRandomWalkableCell();
    val endPoint = maze.getRandomWalkableCell();

    /* practice implementations */
    val pathfinder = PathfinderConvertDfsToBfsPractice(maze);
//    val pathfinder = PathfinderDFS(maze);
//    val pathfinder = PathfinderDijkstraPractice(maze);
//    val pathfinder = PathfinderGreedyBestFirst(maze);
//    val pathfinder = PathfinderBfsPractice(maze);

    /* kollie implementations */
//    val pathfinder: PathfinderBase = PathfinderBFS(maze);
//    val pathfinder: PathfinderBase = PathfinderDijkstra(maze);
//    val pathfinder: PathfinderBase = PathfinderGreedyBestFirst(maze);

    val path = pathfinder.computePath(startPoint, endPoint);

    val renderer = MazeRenderer(maze);

    renderer.setStartPoint(startPoint);
    renderer.setEndPoint(endPoint);

    renderer.setPath(path);
    renderer.setExploredCells(pathfinder.ExploredNodes);
    renderer.setFrontierCells(pathfinder.FrontierNodes);

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