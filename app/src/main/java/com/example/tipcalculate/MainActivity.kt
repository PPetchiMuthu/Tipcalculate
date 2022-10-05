package com.example.tipcalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculate.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringText = binding.textView.text.toString()
        val cost = stringText.toDouble()
        val tipPercentage = when (binding.button.checkedRadioButtonId) {
            R.id.button1 -> 0.20
            R.id.button2 -> 0.18
            else -> 0.15
        }
        var tip = cost * tipPercentage
        val roundUp = binding.switchCondition.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}
