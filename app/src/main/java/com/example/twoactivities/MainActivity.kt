package com.example.twoactivities

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


private val LOG_TAG = MainActivity::class.java.getSimpleName()
const val TEXT_REQUEST = 1 //Step 4.4.2

class MainActivity : AppCompatActivity() {
    companion object{
        // Шаг 2. Добавьте publicконстанту вверху класса, чтобы определить Intent дополнительный ключ:
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        //Шаг 3. Добавьте приватную переменную вверху класса для хранения EditText:
        //private EditText mMessageEditText;
        private var mMessageEditText: EditText? = null
        private var mReplyHeadTextView: TextView? = null // Step 4.4.3
        private var mReplyTextView: TextView? = null // Step 4.4.3

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Шаг 4. В onCreate()методе используйте, findViewById()чтобы получить ссылку на EditTextи назначить ее этой частной переменной:
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply) //Step 4.4.4
        mReplyTextView = findViewById(R.id.text_message_reply) //Step 4.4.4
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = mMessageEditText?.getText().toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        // startActivity(intent) // Step 4.4.5 this string was comented in this step
        startActivityForResult(intent, TEXT_REQUEST);//Step 4.4.5
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(EXTRA_REPLY)
                mReplyHeadTextView?.setVisibility(View.VISIBLE)
                mReplyTextView?.setText(reply)
                mReplyTextView?.setVisibility(View.VISIBLE)
            }

        }

    }

}