package br.edu.ifrs.poa.travelzen.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import br.edu.ifrs.poa.travelzen.R

class TravelFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_form)
        val mySpinner = findViewById<Spinner>(R.id.activity_travel_form_rate_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.rating_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = adapter
    }
}