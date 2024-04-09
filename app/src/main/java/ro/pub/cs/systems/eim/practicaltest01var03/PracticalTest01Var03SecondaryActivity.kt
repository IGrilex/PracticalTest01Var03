package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {

    companion object {
        const val RESULT_KEY = "result_key"
    }

    private lateinit var operationTextView: TextView
    private lateinit var correctButton: Button
    private lateinit var incorrectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secundary)

        // Inițializează elementele UI folosind findViewById
        operationTextView = findViewById(R.id.operationTextView)
        correctButton = findViewById(R.id.correctButton)
        incorrectButton = findViewById(R.id.incorrectButton)

        // Extrage rezultatul din intentul primit
        val result = intent.getStringExtra(RESULT_KEY)
        operationTextView.text = result

        correctButton.setOnClickListener {
            // Trimiti un intent catre activitatea principala
            val intent = Intent(this@PracticalTest01Var03SecondaryActivity, PracticalTest01Var03MainActivity::class.java)
            startActivity(intent)
        }

        incorrectButton.setOnClickListener {
            // Trimiti un intent catre activitatea principala
            val intent = Intent(this@PracticalTest01Var03SecondaryActivity, PracticalTest01Var03MainActivity::class.java)
            startActivity(intent)
        }
    }
}
