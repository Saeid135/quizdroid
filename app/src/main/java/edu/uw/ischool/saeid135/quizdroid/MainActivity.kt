package edu.uw.ischool.saeid135.quizdroid

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.content.Intent
import androidx.activity.ComponentActivity
import android.app.Application
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable


data class Quiz(val text: String,
                val answers: Array<String>,
                val answer: Int)

data class Topic(val title: String, val desc: String, val questions: List<Quiz>)

interface TopicRepository {
    fun getAll() : List<Topic>
}

class TopicRepoValues(val context : Context) : TopicRepository {
    val type = object : TypeToken<List<Topic>>() {}.type
    val gson = Gson()
    val json: String = context.resources.openRawResource(R.raw.questions).bufferedReader().use { it.readText() }
    val topicsList : List<Topic> = gson.fromJson(json, type)

    override fun getAll() : List<Topic> {
        return topicsList
    }
}

class QuizApplication : Application() {
    lateinit var quizRepository : TopicRepository

    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp", "onCreate()")
        quizRepository = TopicRepoValues(this)
    }
}

class MainActivity : ComponentActivity() {
    lateinit var listView : ListView
    var allTopics: List<Topic> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val finalQuiz = (application as QuizApplication)
        val repository = finalQuiz.quizRepository
        allTopics = repository.getAll()
        listView = findViewById(R.id.listView)
        val newTopics = allTopics.map {it.title}
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, newTopics)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("chosenTopic", newTopics[position])
            val gson = Gson()
            val json = gson.toJson(allTopics)
            intent.putExtra("topicsList", json)
            startActivity(intent)
        }

    }
}
