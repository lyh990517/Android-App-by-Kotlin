package yunho.app.secretmemo

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DairyActivity : AppCompatActivity() {
    private val Content1:EditText by lazy {
        findViewById<EditText>(R.id.content)
    }
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dairy)
        val content = getSharedPreferences("dairy", Context.MODE_PRIVATE)
        Content1.setText(content.getString("content", ""))

        val runnable = Runnable {
            getSharedPreferences("dairy", Context.MODE_PRIVATE).edit {
                putString("content", Content1.text.toString())
            }
        }

        Content1.addTextChangedListener {

            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable,500)
        //    content.edit {
        //        putString("content", Content1.text.toString())
        //    }
        }

    }
}