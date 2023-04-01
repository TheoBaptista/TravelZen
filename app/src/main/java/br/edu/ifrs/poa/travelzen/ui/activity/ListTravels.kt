package br.edu.ifrs.poa.travelzen.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.edu.ifrs.poa.travelzen.R

class ListTravels : AppCompatActivity(R.layout.activity_list_travels) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val addTravelButton = findViewById<Button>(R.id.activity_list_travels_add_travel_button)

        addTravelButton.setOnClickListener {
            val intent = Intent(this,TravelFormActivity::class.java)
            startActivity(intent)
        }
    }
}