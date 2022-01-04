package yunho.app.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.heightEdit)
        val weightEditText: EditText = findViewById(R.id.weightEdit)
        val resultButton = findViewById<Button>(R.id.resultButton)
        val beforeBMI = findViewById<TextView>(R.id.BeforeBMI)
        val beforeResult = findViewById<TextView>(R.id.BeforeRES)
        val beforeHeight = findViewById<TextView>(R.id.Beforeheight)
        val beforeWeight = findViewById<TextView>(R.id.Beforeweight)

        val BeforeBMIVal = intent.getDoubleExtra("BMIResult",0.0)
        val BeforeResultval = intent.getStringExtra("StringResult")
        val BeforehHeightVal = intent.getIntExtra("height",0)
        val BeforeWeightVal = intent.getIntExtra("weight",0)

        beforeHeight.text = BeforehHeightVal.toString()
        beforeWeight.text = BeforeWeightVal.toString()
        beforeBMI.text = BeforeBMIVal.toString()
        beforeResult.text = BeforeResultval

        resultButton.setOnClickListener {
            Log.d("mainActivity","clicked")
            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈값이 있어요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }//예외처리

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)

            startActivity(intent)
        }
    }
}