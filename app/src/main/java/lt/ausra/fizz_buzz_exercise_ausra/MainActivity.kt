package lt.ausra.fizz_buzz_exercise_ausra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var textListView: ListView
    lateinit var adapter: ArrayAdapter<String>
    lateinit var clickMeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickMeButton = findViewById(R.id.clickMeButton)

        doFizzBuzzTask()

        clickMeButton.setOnClickListener {
            doFizzBuzzBonusTask()
        }
    }

    private fun doFizzBuzzTask() {

        val array = Array(100) { "$it" }

        for (item in 1..100) {
            if (item % 3 == 0 && item % 5 == 0) {
                array[item - 1] = "FIZZBUZZ"
            } else if (item % 3 == 0) {
                array[item - 1] = "FIZZ"
            } else if (item % 5 == 0) {
                array[item - 1] = "BUZZ"
            } else {
                array[item - 1] = item.toString()
            }
        }

        textListView = findViewById(R.id.textListView)
        adapter = ArrayAdapter(
            this, android.R.layout.simple_expandable_list_item_1, array
        )
        textListView.adapter = adapter
    }

    private fun doFizzBuzzBonusTask() {

        val cycleStart = (-50..50).random()
        val cycleLength = (50..150).random()
        val cycleEnd: Int = if (cycleStart >= 0) {
            cycleLength + cycleStart
        } else {
            cycleLength - abs(cycleStart)
        }

        val array = ArrayList<String>()

        for (item in cycleStart..cycleEnd) {
            if (item % 3 == 0 && item % 5 == 0) {
                array.add("FIZZBUZZ")
            } else if (item % 3 == 0) {
                array.add("FIZZ")
            } else if (item % 5 == 0) {
                array.add("BUZZ")
            } else {
                array.add(item.toString())
            }
        }

        textListView = findViewById(R.id.textListView)
        adapter = ArrayAdapter(
            this, android.R.layout.simple_expandable_list_item_1, array
        )
        textListView.adapter = adapter
    }
}