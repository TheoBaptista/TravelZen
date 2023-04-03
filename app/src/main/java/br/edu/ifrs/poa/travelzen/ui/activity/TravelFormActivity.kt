package br.edu.ifrs.poa.travelzen.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import br.edu.ifrs.poa.travelzen.R
import br.edu.ifrs.poa.travelzen.dao.TravelDao
import br.edu.ifrs.poa.travelzen.model.Travel

class TravelFormActivity : AppCompatActivity() {

    private var selectedItem: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_form)

        // configure spinner
        val spinner = configureSpinner()

        // get spinner value
        getRateValue(spinner)

        // configure save button
        val button = findViewById<Button>(R.id.activity_travel_form_button)
        val travelDao = TravelDao()

        // save travel when button clicked
        button.setOnClickListener {
            val travel = createTravel(selectedItem.orEmpty())

            if (travel.destiny.isNotBlank()) {
                travelDao.add(travel)
                Log.i("CreateTravel", "travel created: $travel")
            }
            finish()
        }
    }

    private fun configureSpinner(): Spinner {
        val mySpinner = findViewById<Spinner>(R.id.activity_travel_form_rate_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.rating_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = adapter
        return mySpinner
    }

    private fun getRateValue(spinner: Spinner) {

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedItem = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedItem = "1"
            }
        }

    }

    private fun createTravel(rateValue: String): Travel {
        val fieldDestiny = findViewById<EditText>(R.id.activity_travel_form_destiny)
        val destiny = fieldDestiny.text.toString()
        val fieldDescription = findViewById<EditText>(R.id.activity_travel_form_description)
        var description = fieldDescription.text.toString()

        if (description.isBlank()){
            description = "Don't have description"
        }

        return Travel(
            destiny = destiny,
            description = description,
            rate = rateValue
        )
    }


}