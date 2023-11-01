package edu.uw.ischool.saeid135.quizdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View
import android.widget.Button
import android.content.Intent
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Question5 : ComponentActivity() {
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
            txt.text = "Q5: What is 10 divided by 5?"
            option1.text = "5"
            option2.text = "2"
            option3.text = "98"
            option4.text = "54"
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
                next.text = "Finish"
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Physics") {
            txt.text = "Q5: What is the term for the minimum angle at which a light ray is reflected" +
                    " back into a material and cannot pass into the surrounding medium?"
            option1.text = "Awkward Angle"
            option2.text = "Critical Angle"
            option3.text = "Final Angle"
            option4.text = "Angle of No Return"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Critical Angle") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Critical Angle. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.text = "Finish"
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        else if (topicQues == "Marvel Super Heroes") {
            txt.text = "Q5: How did the Hulk gain his powers?"
            option1.text = "Gamma Ray Exposure"
            option2.text = "Working out"
            option3.text = "Super Soldier Serum"
            option4.text = "None of the above"
            btn.setOnClickListener{
                val chosenBtn = radioGrp.checkedRadioButtonId
                val pickedAns = findViewById<RadioButton>(chosenBtn)
                val answer = pickedAns.text.toString()
                if (answer == "Gamma Ray Exposure") {
                    count += 1
                }
                result.text = "The answer you gave is ${answer}. The correct" +
                        " answer is Gamma Ray Exposure. You have ${count} out of 5 correct."
                btn.isEnabled = false
                next.text = "Finish"
                next.visibility = View.VISIBLE
                next.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}