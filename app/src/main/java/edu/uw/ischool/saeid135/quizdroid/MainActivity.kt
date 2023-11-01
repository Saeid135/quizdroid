package edu.uw.ischool.saeid135.quizdroid

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.content.Intent
import androidx.activity.ComponentActivity


val topics = arrayOf(
    "Math",
    "Physics",
    "Marvel Super Heroes"
)

class MainActivity : ComponentActivity() {
    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, topics)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("chosenTopic", topics[position])
            startActivity(intent)
        }

    }
}
