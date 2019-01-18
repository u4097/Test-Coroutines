package ositnikov.testcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ositnikov.testcoroutines.R
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("COROUTINE","")
        Log.e("COROUTINE", "Starting compute:  - - - >")

        val deferred = (1..1_000_000).map { n ->
            GlobalScope.async {
                delay(1_000)
                n
            }
        }

        runBlocking {
            val sum = deferred.sumBy { it.await() }
            Log.e("COROUTINE", "Result: ${sum}")
        }

/*
        val list = (1..1_000).map { n ->
            Thread.sleep(100)
            n
        }
        val sum = list.sumBy { it }
        Log.e("COROUTINE", "Result comlete!: ${sum}")
*/

    }
}
