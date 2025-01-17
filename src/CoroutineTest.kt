import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun topLevelCoroutineScope() = coroutineScope {

    launch {
        mySecondCoroutineContext();
    }

    launch {
        myCoroutineContext();
    }
}

suspend fun mySecondCoroutineContext() = coroutineScope {

    launch {
        delay(100)
        println("second context done working...");
    }

    println("second context working!");
}

suspend fun myCoroutineContext() = coroutineScope {

    launch {
        printWorldDelayed();
    }

    println("Hello again,");
}

suspend fun printWorldDelayed() {

    delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
    println(" World!") // print after delay
}