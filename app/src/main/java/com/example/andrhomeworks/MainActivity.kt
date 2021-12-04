package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.andrhomeworks.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            //numbers
            one.setOnClickListener { appendonExpresstion("1", true) }
            two.setOnClickListener { appendonExpresstion("2", true) }
            three.setOnClickListener { appendonExpresstion("3", true) }
            four.setOnClickListener { appendonExpresstion("4", true) }
            five.setOnClickListener { appendonExpresstion("5", true) }
            six.setOnClickListener { appendonExpresstion("6", true) }
            seven.setOnClickListener { appendonExpresstion("7", true) }
            eight.setOnClickListener { appendonExpresstion("8", true) }
            nine.setOnClickListener { appendonExpresstion("9", true) }
            zero.setOnClickListener { appendonExpresstion("0", true) }
            //operators
            plus.setOnClickListener { appendonExpresstion("+", false) }
            minus.setOnClickListener { appendonExpresstion("-", false) }
            multiplication.setOnClickListener { appendonExpresstion("*", false) }
            division.setOnClickListener { appendonExpresstion("/", false) }
            firstBracket.setOnClickListener { appendonExpresstion("(", false) }
            secondBracket.setOnClickListener { appendonExpresstion(")", false) }
            point.setOnClickListener { appendonExpresstion(".", false) }
            clean.setOnClickListener {
                expression.text = ""
                result.text = ""
            }
            back.setOnClickListener {
                val string = expression.text.toString()
                if (string.isNotEmpty()) {
                    expression.text = string.substring(0, string.length - 1)
                }
                result.text = ""
            }
            equals.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(binding.expression.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble())
                        binding.result.text = longResult.toString()
                    else
                        binding.result.text = result.toString()

                } catch (e: Exception) {
                    Log.d("Exeption", "msg:" + e.message)
                    binding.result.text = "error!"
                } catch (e: ArithmeticException) {
                    Log.e("Exeption :", "msg:" + e.message)
                    binding.result.text = "error!"
                }
            }
        }
    }

    fun appendonExpresstion(string: String, canClear: Boolean) {
        binding.apply {
            if (result.text.isNotEmpty()) {
                expression.text = ""
            }
            if (canClear) {
                result.text = ""
                expression.append(string)
            } else {
                expression.append(binding.result.text)
                expression.append(string)
                result.text = ""
            }
        }
    }
}