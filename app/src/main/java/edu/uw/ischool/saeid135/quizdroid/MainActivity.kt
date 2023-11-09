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
import java.io.Serializable


data class Quiz(val questionTxt: String, val ans1: String,
                val ans2: String, val ans3: String,
                val ans4: String, val correct: Int)

data class Topic(val title: String, val shortDesc: String,
                 val longDesc: String, val questions: List<Quiz>)

interface TopicRepository {
    fun getAll() : List<Topic>
}

class TopicRepoValues(val context : Context) : TopicRepository {
    private val mathQuizzes = listOf(
        Quiz("Q1: What is 1 + 1?", "1", "2",
            "3", "4", 2),
        Quiz("Q2: What is the square root of 121?", "9",
            "7", "32", "11", 4),
        Quiz("Q3: What is 10 times 10?", "97", "100",
            "5", "1000", 2),
        Quiz("Q4: What is 37 - 5?", "8", "30", "32",
            "24", 3),
        Quiz("Q5: What is 10 divided by 5?", "5", "2",
            "98", "54", 2)
    )
    private val phyQuizzes = listOf(
        Quiz("Q1: What is the SI unit of force?", "Newtons (N)",
            "Electrons", "Inches", "Centimeters", 1),
        Quiz("Q2: Which electromagnetic radiation transmits the highest photon energy?",
            "Radio waves", "Gamma rays", "Microwaves", "Infrared", 2),
        Quiz("Q3: Which part of the eye has the greatest density of light receptors?",
            "Retina", "Iris", "Pupil", "Fovea", 4),
        Quiz("Q4: What does the term \"IMA\" stand for in the context of simple machines?",
            "Mighty Astonishment", "Medical Advantage", "Mechanical Advantage",
            "Motor Advancement", 3),
        Quiz("Q5: What is the term for the minimum angle at which a light ray is reflected" +
                " back into a material and cannot pass into the surrounding medium?",
            "Awkward Angle", "Critical Angle", "Final Angle", "Angle of No Return",
            2)
    )
    private val marvelQuizzes = listOf(
        Quiz("Q1: Who is a part of the X-men?", "Wolverine", "Spiderman",
            "Iron Man", "The Hulk", 1),
        Quiz("Q2: Who has Spider Sense?", "Black Panther", "Antman",
            "Spiderman", "Falcon", 3),
        Quiz("Q3: Which one of these villains is commonly associated with Wolverine?",
            "Yellow Jacket", "Magneto", "Venom", "Abomination", 2),
        Quiz("Q4: Which Borough does Spiderman originate from?", "Queens",
            "Brooklyn", "Manhattan", "None of the above", 1),
        Quiz("Q5: How did the Hulk gain his powers?", "Gamma Ray Exposure",
            "Working out", "Super Soldier Serum", "None of the above", 1)
    )
    private val allTopics = listOf(
        Topic("Math", "A quiz about Math", "This is a quiz about the topic" +
                " of Mathematics. This is a topic that consists of, in simple terms," +
                "  the study of numbers, patterns, and relationships. This quiz will have " +
                "five questions.", mathQuizzes),
        Topic("Physics", "A quiz about Physics", "This is a quiz about " +
                "Physics. It asks some questions " +
                "that fall into the vast topic of Physics, a branch of" +
                " science that delves into the study of matter, motion, and energy. " +
                "This quiz will have five questions.", phyQuizzes),
        Topic("Marvel Super Heroes", "A quiz about Marvel Super Heroes",
            "This is a quiz about Physics. It asks some questions " +
                    "that fall into the vast topic of Physics, a branch of" +
                    " science that delves into the study of matter, motion, and energy. " +
                    "This quiz will have five questions.", marvelQuizzes)
    )
    override fun getAll() : List<Topic> {
        return allTopics
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
