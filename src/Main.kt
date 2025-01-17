import com.wizneylabs.leetcoding.GridRenderer
import com.wizneylabs.leetcoding.exercises.HashTableLeetcode
import com.wizneylabs.leetcoding.MaxHeap
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() = runBlocking {

    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}