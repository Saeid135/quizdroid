package edu.uw.ischool.saeid135.quizdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View
import android.widget.Button
import android.content.Intent
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Question4 : ComponentActivity() {
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
//        val chosenBtn = radioGrp.checkedRadioButtonId
//        radioBtn = findViewById<RadioButton>(chosenBtn)
//        Log.i("tag", radioBtn.toString())
        radioGrp.setOnCheckedChangeListener { group, checkedId ->
            btn.isEnabled = true
        }
        if (topicQues == "Math") {
            txt.text = "Q4: What is 37 - 5?"
            option1.text = "8"
            option2.text = "30"
            option3.text = "32"
            option4.text = "24"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "32") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is 32. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question5::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Physics") {
            txt.text = "Q4: What does the term \"IMA\" stand for in the context of simple machines?"
            option1.text = "Mighty Astonishment"
            option2.text = "Medical Advantage"
            option3.text = "Mechanical Advantage"
            option4.text = "Motor Advancement"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Mechanical Advantage") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Mechanical Advantage. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question5::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Marvel Super Heroes") {
            txt.text = "Q4: Which Borough does Spiderman originate from?"
            option1.text = "Queens"
            option2.text = "Brooklyn"
            option3.text = "Manhattan"
            option4.text = "None of the above"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Queens") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Queens. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, Question5::class.java)
                    intent.putExtra("chosenTopic", topicQues)
                    intent.putExtra("countValue", count)
                    startActivity(intent)
                }
            }
        }

    }
}