package yunho.app.bmi_calculator

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val returnButton = findViewById<Button>(R.id.GoMain)

        val bmi = weight  / (height / 100.0).pow(2.0)
        val resultText = when {
            bmi  >= 35.0 -> "고도 비만"
            bmi  >= 30.0 -> "중등도 비만"
            bmi  >= 25.0 -> "경도 비만"
            bmi  >= 23.0 -> "과체중"
            bmi  >= 18.5 -> "정상체중"
            else -> "저체중"
        }
        val resultValueTextView = findViewById<TextView>(R.id.BMI)
        val resultStringTextView = findViewById<TextView>(R.id.RES)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
        when {
            resultText == "고도 비만" -> resultStringTextView.setTextColor(Color.BLACK)
            resultText == "중등도 비만" -> resultStringTextView.setTextColor(Color.RED)
            resultText == "경도 비만" -> resultStringTextView.setTextColor(Color.YELLOW)
            resultText == "과체중" -> resultStringTextView.setTextColor(Color.LTGRAY)
            resultText == "정상체중" -> resultStringTextView.setTextColor(Color.GREEN)
            else -> resultStringTextView.setTextColor(Color.BLUE)

        }

        returnButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("BMIResult",bmi)
            intent.putExtra("StringResult",resultText)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)
        }
    }
}