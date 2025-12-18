package com.example.ordering_system

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_sec : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sec)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val beverage = findViewById<TextView>(R.id.input)
        val sugar = findViewById<RadioGroup>(R.id.RadioGroup)
        val ice = findViewById<RadioGroup>(R.id.RadioGroup2)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            if (beverage.text.isEmpty()) {
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            } else {

                val b = bundleOf(
                    "drink" to beverage.text.toString(),
                    "sugar" to sugar.findViewById<RadioButton>(
                        sugar.checkedRadioButtonId
                    ).text.toString(),
                    "ice" to ice.findViewById<RadioButton>(
                        ice.checkedRadioButtonId
                    ).text.toString()
                )

                val i = Intent().putExtras(b)

                setResult(RESULT_OK, i)
                finish()
            }
        }
    }
}