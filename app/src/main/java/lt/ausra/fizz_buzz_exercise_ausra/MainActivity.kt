package lt.ausra.fizz_buzz_exercise_ausra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var textListView: ListView
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doFizzBuzzTask()
    }

    private fun doFizzBuzzTask() {

        val array = Array(100){"$it"}

        for (item in 1..100) {
            if (item % 3 == 0 && item % 5 == 0) {
                array[item - 1] = "FIZZBUZZ"
            } else if (item % 3 == 0) {
                array[item - 1] = "FIZZ"
            } else if (item % 5 == 0) {
                array[item - 1] = "BUZZ"
            } else { array[item - 1] = item.toString()
            }
        }

        textListView = findViewById(R.id.textListView)
        adapter = ArrayAdapter(
            this, android.R.layout.simple_expandable_list_item_1, array
        )
        textListView.adapter = adapter
    }
}