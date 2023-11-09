package edu.uw.ischool.saeid135.quizdroid

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.util.Log


class DetailActivity : ComponentActivity() {
    private lateinit var btn : Button
    private lateinit var txt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val topicDesc = intent.getStringExtra("chosenTopic")
        val json = intent.getStringExtra("topicsList")
        val gson = Gson()
        val type = object : TypeToken<List<Topic>>() {}.type
        val topicsList : List<Topic> = gson.fromJson(json, type)
        btn = findViewById(R.id.btn)
        txt = findViewById(R.id.txt)
        if (topicDesc == "Math") {
            txt.text = topicsList[0].longDesc
            btn.setOnClickListener {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("chosenTopic", topicDesc)
                intent.putExtra("topicsList", json)
                startActivity(intent)
            }
        }
        else if (topicDesc == "Physics") {
            txt.text = topicsList[1].longDesc
            btn.setOnClickListener {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("chosenTopic", topicDesc)
                intent.putExtra("topicsList", json)
                startActivity(intent)
            }
        }
        else if (topicDesc == "Marvel Super Heroes") {
            txt.text = topicsList[2].longDesc
            btn.setOnClickListener {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("chosenTopic", topicDesc)
                intent.putExtra("topicsList", json)
                startActivity(intent)
            }
        }

    }

}