package com.example.karb_lab_32

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startNumberEditText = findViewById<EditText>(R.id.startNumberEditText)
        val endNumberEditText = findViewById<EditText>(R.id.endNumberEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val startNumberText = startNumberEditText.text.toString()
            val endNumberText = endNumberEditText.text.toString()

            if (startNumberText.isNotEmpty() && endNumberText.isNotEmpty()) {
                val startNumber = startNumberText.toIntOrNull()
                val endNumber = endNumberText.toIntOrNull()

                if (startNumber != null && endNumber != null && startNumber <= endNumber) {
                    val sum = (startNumber..endNumber).sum()
                    resultTextView.text = "Sum of numbers from $startNumber to $endNumber is $sum"
                } else {
                    Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both start and end numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
