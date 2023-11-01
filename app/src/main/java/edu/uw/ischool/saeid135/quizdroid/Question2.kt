package edu.uw.ischool.saeid135.quizdroid

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Question2 : ComponentActivity() {
    private lateinit var radioGrp : RadioGroup
    private lateinit var option1 : RadioButton
    private lateinit var option2 : RadioButton
    private lateinit var option3 : RadioButton
    private lateinit var option4 : RadioButton
    private lateinit var txt : TextView
    private lateinit var result : TextView
    private lateinit var btn : Button
    private lateinit var next : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        val topicQues = intent.getStringExtra("chosenTopic")
        var count = intent.getIntExtra("countValue", 0)
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
            btn.isEnabled = true
        }
        if (topicQues == "Math") {
            txt.text = "Q2: What is the square root of 121?"
            option1.text = "9"
            option2.text = "7"
            option3.text = "32"
            option4.text = "11"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "11") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is 11. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question3::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Physics") {
            txt.text = "Q2: Which electromagnetic radiation transmits the highest photon energy?"
            option1.text = "Radio waves"
            option2.text = "Gamma rays"
            option3.text = "Microwaves"
            option4.text = "Infrared"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Gamma rays") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Gamma rays. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question3::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Marvel Super Heroes") {
            txt.text = "Q2: Who has Spider Sense?"
            option1.text = "Black Panther"
            option2.text = "Antman"
            option3.text = "Spiderman"
            option4.text = "Falcon"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Spiderman") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Spiderman. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question3::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    startActivity(intent)
                }
            }
        }

    }
}