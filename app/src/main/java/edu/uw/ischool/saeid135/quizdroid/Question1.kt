package edu.uw.ischool.saeid135.quizdroid

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.util.Log



class Question1 : ComponentActivity() {
    private lateinit var radioGrp : RadioGroup
    private lateinit var option1 : RadioButton
    private lateinit var option2 : RadioButton
    private lateinit var option3 : RadioButton
    private lateinit var option4 : RadioButton
    private lateinit var txt : TextView
    private lateinit var result : TextView
    private lateinit var btn : Button
    private lateinit var next : Button
    private var count: Int = 0
    private var json : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        val topicQues = intent.getStringExtra("chosenTopic")
        json = intent.getStringExtra("topicsList")
        val gson = Gson()
        val type = object : TypeToken<List<Topic>>() {}.type
        val topicsList : List<Topic> = gson.fromJson(json, type)
        radioGrp = findViewById<RadioGroup>(R.id.radio_group)
        btn = findViewById(R.id.btn)
        next = findViewById(R.id.next)
        txt = findViewById(R.id.txt)
        result = findViewById(R.id.result)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        radioGrp.setOnCheckedChangeListener { group, checkedId ->
            if (next.visibility == View.INVISIBLE) {
                btn.isEnabled = true
            }
        }
        if (topicQues == "Math") {
            txt.text = topicsList[0].questions[0].questionTxt
            option1.text = topicsList[0].questions[0].ans1
            option2.text = topicsList[0].questions[0].ans2
            option3.text = topicsList[0].questions[0].ans3
            option4.text = topicsList[0].questions[0].ans4
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "2") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is 2. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question2::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    intent.putExtra("topicsList", json)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Physics") {
            txt.text = topicsList[1].questions[0].questionTxt
            option1.text = topicsList[1].questions[0].ans1
            option2.text = topicsList[1].questions[0].ans2
            option3.text = topicsList[1].questions[0].ans3
            option4.text = topicsList[1].questions[0].ans4
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Newtons (N)") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Newtons (N). You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question2::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    intent.putExtra("topicsList", json)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Marvel Super Heroes") {
            txt.text = topicsList[2].questions[0].questionTxt
            option1.text = topicsList[2].questions[0].ans1
            option2.text = topicsList[2].questions[0].ans2
            option3.text = topicsList[2].questions[0].ans3
            option4.text = topicsList[2].questions[0].ans4
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Wolverine") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Wolverine. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question2::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    intent.putExtra("topicsList", json)
                    startActivity(intent)
                }
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}