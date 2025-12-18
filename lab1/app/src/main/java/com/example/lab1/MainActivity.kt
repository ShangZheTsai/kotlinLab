package com.example.lab1

import android.R.attr.text
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edname = findViewById<EditText>(R.id.edname)
        val tvText = findViewById<TextView>(R.id.tvText)
        val btnMora = findViewById<Button>(R.id.btnMora)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvWinner = findViewById<TextView>(R.id.tvWinner)
        val tvMyMora = findViewById<TextView>(R.id.tvMyMora)
        val tvTargetMora = findViewById<TextView>(R.id.tvTargetMora)

        btnMora.setOnClickListener()
        {
            if (edname.text.isEmpty())
            {
                tvText.text = "請輸入玩家姓名"
                return@setOnClickListener
            }

            val playerName = edname.text.toString()
            val targetMora = (0..2).random()
            val myMora = when(radioGroup.checkedRadioButtonId)
            {
                R.id.btnScissor -> 0
                R.id.btnStone -> 1
                else -> 2
            }
            tvName.text = "${"名字"}\n$playerName"
            tvMyMora.text = "${"我方出拳"}\n${getMoraString(myMora)}"
            tvTargetMora.text ="${"電腦出拳"}\n${getMoraString(targetMora)}"

            when
            {
                myMora == targetMora ->
                {
                    tvText.text = "平手"
                    tvWinner.text = "${"勝利者"}\n${"平手"}"
                }
                (myMora==0 && targetMora==2) ||
                        (myMora==1 && targetMora==0) ||
                        (myMora==2 && targetMora==1)  ->
                {
                    tvText.text = "您獲勝了!"
                    tvWinner.text = "${"勝利者"}\n$playerName"
                }
                else ->
                {
                    tvText.text = "電腦獲勝了!"
                    tvWinner.text = "${"勝利者"}\n${"電腦"}"
                }
            }
        }
    }

    private fun getMoraString(mora:Int): String
    {
        return when (mora)
        {
            0 -> "剪刀"
            1 -> "石頭"
            else -> "布"
        }
    }
}