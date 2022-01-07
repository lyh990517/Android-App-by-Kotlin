package yunho.app.secretmemo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    private val numberPicker1: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.firstNumberPicker)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker2: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.secondNumberPicker)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker3: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.thirdNumberPicker)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val unlockButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.openButton)
    }
    private val pwsetButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.changePasswordButton)
    }
    private var ChangePw = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1
        numberPicker2
        numberPicker3

        unlockButton.setOnClickListener{
            if(ChangePw) {
                Toast.makeText(this, "비밀번호 변경중",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val Password = getSharedPreferences("password",Context.MODE_PRIVATE)
            val InputPassword = numberPicker1.value.toString() + numberPicker2.value.toString() + numberPicker3.value.toString()
            if(Password.getString("password","000").equals(InputPassword)){
                val intent = Intent(this,DairyActivity::class.java)
                startActivity(intent)
            }else{
                AlertMessage("fail","wrong password")
            }
        }
        pwsetButton.setOnClickListener {
            if(ChangePw){
                //번호저장
                val Password = getSharedPreferences("password",Context.MODE_PRIVATE)
                val InputPassword = numberPicker1.value.toString() + numberPicker2.value.toString() + numberPicker3.value.toString()
                Password.edit {
                    putString("password",InputPassword)
                    commit()
                }
                ChangePw = false
                Toast.makeText(this,"번호 설정 완료",Toast.LENGTH_SHORT).show()
                pwsetButton.setBackgroundColor(Color.BLACK)

            }else{
                //활성화
                val Password = getSharedPreferences("password",Context.MODE_PRIVATE)
                val InputPassword = numberPicker1.value.toString() + numberPicker2.value.toString() + numberPicker3.value.toString()
                if(Password.getString("password","000").equals(InputPassword)){
                    ChangePw = true
                    Toast.makeText(this,"원하는 번호 설정 후 한번 더 클릭하세요",Toast.LENGTH_SHORT).show()
                    pwsetButton.setBackgroundColor(Color.RED)
                }else{
                    AlertMessage("번호 변경","진입 실패")
                }
            }
        }
    }
    private fun AlertMessage(Title:String , Message: String){
        AlertDialog.Builder(this)
            .setTitle(Title)
            .setMessage(Message)
            .setPositiveButton("확인"){ _, _ ->}
            .create()
            .show()
    }
}
