package com.example.andrhomeworks

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    private var datePickerDialog: DatePickerDialog? = null
    private var dateButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDatePicker()
        dateButton = findViewById(R.id.datePickerButton)
        with(dateButton) { this?.setText(todaysDate) }
    }

    private val todaysDate: String
        get() {
            val cal = Calendar.getInstance()
            val year = cal[Calendar.YEAR]
            var month = cal[Calendar.MONTH]
            month += 1
            val day = cal[Calendar.DAY_OF_MONTH]
            return makeDateString(day, month, year)
        }

    private fun initDatePicker() {
        val dateSetListener =
            OnDateSetListener { _, year, month, day ->
                var month = month
                month += 1
                val date = makeDateString(day, month, year)
                dateButton!!.text = date
            }
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        val style = AlertDialog.THEME_HOLO_LIGHT
        datePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return getMonthFormat(month)
    }

    private fun getMonthFormat(month: Int): String {
        if (month == 1) return "winter"
        if (month == 2) return "winter"
        if (month == 3) return "spring"
        if (month == 4) return "spring"
        if (month == 5) return "spring"
        if (month == 6) return "summer"
        if (month == 7) return "summer"
        if (month == 8) return "summer"
        if (month == 9) return "autumn"
        if (month == 10) return "autumn"
        if (month == 11) return "autumn"
        return if (month == 12) "winter" else "winter"
    }

    fun openDatePicker(view: View?) {
        datePickerDialog!!.show()
    }
}
