package br.edu.ifrs.poa.travelzen.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.edu.ifrs.poa.travelzen.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainButton = findViewById<Button>(R.id.activity_main_enter_button)

        mainButton.setOnClickListener {
            val intent = Intent(this,ListTravels::class.java)
            startActivity(intent)
        }
    }
}