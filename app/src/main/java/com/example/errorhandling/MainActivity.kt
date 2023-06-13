package com.example.errorhandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.errorhandling.presentation.MyViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)

        val submit = findViewById<Button>(R.id.submit_button)
        val textView = findViewById<TextView>(R.id.text_view)
        val myViewModel by viewModels<MyViewModel>()

        submit.setOnClickListener { myViewModel.submitEmail(editText.text.toString()) }
        myViewModel.error.observe(this) {
            textView.text = it
        }
    }
}