package yunho.app.lottonumbergenerater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity() {

    private val clearButton: Button by lazy {
        findViewById(R.id.clear)
    }
    private val addButton: Button by lazy {
        findViewById(R.id.add)
    }
    private val generateButton: Button by lazy {
        findViewById(R.id.generate)
    }
    private val numberPicker: NumberPicker by lazy {
        findViewById(R.id.numberPicker)
    }

    private val numberTextViewList: List<TextView> by lazy {
        listOf<TextView>(
            findViewById(R.id.first),
            findViewById(R.id.second),
            findViewById(R.id.third),
            findViewById(R.id.forth),
            findViewById(R.id.fifth),
            findViewById(R.id.sixth)
        )
    }
    private val numberTextViewList2: List<TextView> by lazy {
        listOf<TextView>(
            findViewById(R.id.sel1),
            findViewById(R.id.sel2),
            findViewById(R.id.sel3),
            findViewById(R.id.sel4),
            findViewById(R.id.sel5)
        )
    }
    private var didRun = false

    private val pickNumberSet = hashSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberPicker.minValue = 1
        numberPicker.maxValue = 45
        initGenerateButton()
        initAddButton()
        initClearButton()
    }

    private fun initGenerateButton() {
        generateButton.setOnClickListener {
            var list = mutableListOf<Int>()
            pickNumberSet.forEach{
                list.add(it)
            }
            val get = getList()
            for(i in pickNumberSet.size..5){
                list.add(get[i])
            }
            list.sort()
            var i = 0
            numberTextViewList.forEach{
                it.text = list[i].toString()
                it.isVisible = true
                setNumberBackground(list[i],it)
                i++
            }
            didRun = true
            Log.d("MainActivity", list.toString())
        }
    }
    private fun setNumberBackground(number: Int, textView: TextView) {
        when(number){
            in 1..10 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circleyellow)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circleblue)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circlered)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circlegray)
            else -> textView.background = ContextCompat.getDrawable(this,R.drawable.circlegreen)
        }
    }
    private fun initAddButton() {
        addButton.setOnClickListener {
            if (didRun) {
                Toast.makeText(this, "이미 생성됨", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pickNumberSet.size >= 5) {
                Toast.makeText(this, "번호는 5개까지 입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pickNumberSet.contains(numberPicker.value)) {
                Toast.makeText(this, "이미 추가된 번호입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val textView = numberTextViewList[pickNumberSet.size]
            val  textView2 = numberTextViewList2[pickNumberSet.size]
            setNumberBackground(numberPicker.value,textView)
            setNumberBackground(numberPicker.value,textView2)
            textView.isVisible = true
            textView.text = numberPicker.value.toString()
            textView2.isVisible = true
            textView2.text = numberPicker.value.toString()
            pickNumberSet.add(numberPicker.value)
        }
    }

    private fun initClearButton(){
        clearButton.setOnClickListener {
            pickNumberSet.clear()
            numberTextViewList.forEach{
                it.isVisible  = false
            }
            numberTextViewList2.forEach{
                it.isVisible  = false
            }
            didRun = false
        }
    }

    private fun getList(): List<Int> {
        val random = Random()
        val numberList = mutableListOf<Int>()
        //while(numberList.size < 6){
        //    val tmp = random.nextInt(45) + 1
        //    if(numberList.contains(tmp) || pickNumberSet.contains(tmp)) continue
        //    numberList.add(tmp)
        //}
        for (i in 1..45) {
            if(pickNumberSet.contains(i)) continue
            numberList.add(i)
        }
        numberList.shuffle()
        val newList = numberList.subList(0, 6)
        return newList.sorted()
    }
}