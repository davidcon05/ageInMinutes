package com.android.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // create and initialize later
    private var selectedStartDate : TextView? = null
    private var ageInMinutes : TextView? = null
    private var title : TextView? = null
    private var selectedDateDescription : TextView? = null
    private var ageInMinsDescription : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize object to id
        val selectDateBtn : Button = findViewById(R.id.selectDateBtn)
        selectedStartDate = findViewById(R.id.selectedStartDate)
        ageInMinutes = findViewById(R.id.ageInMinutes)
        title = findViewById(R.id.title)
        selectedDateDescription = findViewById(R.id.selectedDateDescription)
        ageInMinsDescription = findViewById(R.id.ageInMinsDescription)

        // Execute age calculation
        selectDateBtn.setOnClickListener{
            selectDate()
        }
    }

    // Performs age calculation
    private fun selectDate() {
        // Calendar object
        val selectDateCalendar = Calendar.getInstance()

        // Variables for grabbing data from object instance
        val selectedYear = selectDateCalendar.get(Calendar.YEAR)
        val selectedMonth = selectDateCalendar.get(Calendar.MONTH)
        val selectedDay = selectDateCalendar.get(Calendar.DAY_OF_MONTH)

        // Using date picker, save the the data to these variables
        val datePickerDialog = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDay ->
                Toast.makeText(this, "Year is $selectedYear, Month is " +
                        "${selectedMonth+1} Day is $selectedDay", Toast.LENGTH_LONG).show()

                // Creates template for displaying date
                val startDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
                // Updates the text for R.id.selectedStartDate
                selectedStartDate?.text = startDate

                val simpleDate = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = simpleDate.parse(startDate)

                // .let only executes if loaded properly
                theDate?.let{
                    val selectedDateInMins = theDate.time / (1000 * 60) // 1000ms * 60s in min
                    val currentDate = simpleDate.parse(simpleDate.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMins = currentDate.time/(60 * 1000)
                        val differenceInMins = currentDateInMins - selectedDateInMins
                        ageInMinutes?.text = differenceInMins.toString()
                    }
                }


            },
            selectedYear,
            selectedMonth,
            selectedDay
        )
        // Set max to pickable dates and display
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis() - (86400000)
        datePickerDialog.show()
    }
}