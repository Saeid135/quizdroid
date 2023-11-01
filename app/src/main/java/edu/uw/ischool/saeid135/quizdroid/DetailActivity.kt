package edu.uw.ischool.saeid135.quizdroid

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.TextView

class DetailActivity : ComponentActivity() {
//    private lateinit var mathBtn : Button
//    private lateinit var phyBtn : Button
//    private lateinit var heroBtn : Button
    private lateinit var btn : Button
    private lateinit var txt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val topicDesc = intent.getStringExtra("chosenTopic")
        btn = findViewById(R.id.btn)
        txt = findViewById(R.id.txt)
        if (topicDesc == "Math") {
            txt.text = "This is a quiz about the topic" +
                    " of Mathematics. This is a topic that consists of, in simple terms," +
                    "  the study of numbers, patterns, and relationships. This quiz will have " +
                    "five questions."
            btn.setOnClickListener {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("chosenTopic", topicDesc)
                startActivity(intent)
            }
        }
        else if (topicDesc == "Physics") {
            txt.text = "This is a quiz about Physics. It asks some questions " +
                    "that fall into the vast topic of Physics, a branch of" +
                    " science that delves into the study of matter, motion, and energy. " +
                    "This quiz will have five questions."
            btn.setOnClickListener {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("chosenTopic", topicDesc)
                startActivity(intent)
            }
        }
        else if (topicDesc == "Marvel Super Heroes") {
            txt.text = "This is a quiz about the topic" +
                    " of the Marvel Super Heroes. It asks several questions " +
                    "regarding some popular characters from the Marvel Universe, created by" +
                    " Stan Lee and Steve Ditko. " +
                    "This quiz will have five questions"
            btn.setOnClickListener {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("chosenTopic", topicDesc)
                startActivity(intent)
            }
        }

    }

}