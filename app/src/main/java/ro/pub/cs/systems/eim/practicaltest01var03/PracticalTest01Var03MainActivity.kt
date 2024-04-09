package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var resultTextView: TextView
    private var result: String = ""
    private var firstNumber: Int = 0
    private var secondNumber: Int = 0

    companion object {
        private const val RESULT_KEY = "result_key"
        private const val FIRST_NUMBER_KEY = "first_number_key"
        private const val SECOND_NUMBER_KEY = "second_number_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.firstNumberEditText)
        secondNumberEditText = findViewById(R.id.secondNumberEditText)
        resultTextView = findViewById(R.id.resultTextView)

        savedInstanceState?.let {
            result = it.getString(RESULT_KEY, "")
            firstNumber = it.getInt(FIRST_NUMBER_KEY, 0)
            secondNumber = it.getInt(SECOND_NUMBER_KEY, 0)
            displayResult(result)
        }
    }

    fun onAddClicked(view: View) {
        computeResult("+")
    }

    fun onSubtractClicked(view: View) {
        computeResult("-")
    }

    fun onGoToSecondActivityClicked(view: View) {
        val intent = Intent(this@PracticalTest01Var03MainActivity, PracticalTest01Var03SecondaryActivity::class.java)
        intent.putExtra(PracticalTest01Var03SecondaryActivity.RESULT_KEY, result) // Trimite rezultatul catre activitatea secundara
        startActivity(intent)
    }

    private fun computeResult(operation: String) {
        val num1Str = firstNumberEditText.text.toString()
        val num2Str = secondNumberEditText.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            showToast("Please fill in both numbers")
            return
        }

        val num1 = num1Str.toIntOrNull()
        val num2 = num2Str.toIntOrNull()

        if (num1 == null || num2 == null) {
            showToast("Please enter valid integer numbers")
            return
        }

        firstNumber = num1
        secondNumber = num2

        result = when (operation) {
            "+" -> "$num1 + $num2 = ${num1 + num2}"
            "-" -> "$num1 - $num2 = ${num1 - num2}"
            else -> ""
        }

        displayResult(result)
    }

    private fun displayResult(result: String) {
        resultTextView.text = result
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(RESULT_KEY, result)
        outState.putInt(FIRST_NUMBER_KEY, firstNumber)
        outState.putInt(SECOND_NUMBER_KEY, secondNumber)
    }
}
