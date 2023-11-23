package edu.uw.ischool.saeid135.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText

lateinit var textEditVal : EditText
lateinit var timeEditVal : EditText
var newUrl : String = ""
var newTime : Int = 0
var checkSet : Int = 0
private lateinit var btn : Button

class Configurations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textEditVal = findViewById(R.id.urlEdit)
        btn = findViewById(R.id.btn)
        textEditVal.visibility = View.VISIBLE
        btn.visibility = View.VISIBLE
        checkSet = intent.getIntExtra("checkSet", 0)
        if (checkSet == 1) {
            textEditVal.inputType = InputType.TYPE_CLASS_TEXT
            newUrl = intent.getStringExtra("newUrl").toString()
            btn.setOnClickListener{
                newUrl = textEditVal.text.toString()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("newUrl", newUrl)
                textEditVal.visibility = View.INVISIBLE
                btn.visibility = View.INVISIBLE
                startActivity(intent)
            }
        }
        else if (checkSet == 2) {
            newTime = intent.getIntExtra("newTime", 0)
            textEditVal.inputType = InputType.TYPE_CLASS_NUMBER
            btn.setOnClickListener{
                newTime = textEditVal.text.toString().toInt()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("newTime", newTime)
                textEditVal.visibility = View.INVISIBLE
                btn.visibility = View.INVISIBLE
                startActivity(intent)
            }
        }
    }
}