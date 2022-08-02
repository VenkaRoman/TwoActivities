package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//Step 4.2.2. At the top of the class, add a public constant to define the key for the Intent extra:
const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
//Step 4.2.3. Add a private variable at the top of the class to hold the EditText.
private var mReply: EditText? = null

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent //Получите то Intent, что активировало это Activity:
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
        mReply = findViewById(R.id.editText_second) //Step 4.2.4

    }

    fun returnReply(view: View) {
        val reply = mReply?.text.toString() //Step 4.2.5
        val replyIntent = Intent() //Step 4.2.6
        replyIntent.putExtra(EXTRA_REPLY, reply) //Step 4.2.7
        setResult(RESULT_OK,replyIntent) //Step 4.2.8
        finish() //Step 4.2.9
    }
}