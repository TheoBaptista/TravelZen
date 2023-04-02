package br.edu.ifrs.poa.travelzen.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifrs.poa.travelzen.R
import br.edu.ifrs.poa.travelzen.dao.TravelDao
import br.edu.ifrs.poa.travelzen.ui.recyclerview.adapter.TravelListAdapter

class ListTravelsActivity : AppCompatActivity(R.layout.activity_list_travels) {

    private val dao = TravelDao()
    private val adapter = TravelListAdapter(context = this, travels = dao.listAll())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configAddButton()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.listAll())
    }

    private fun configAddButton() {
        val addTravelButton = findViewById<Button>(R.id.activity_list_travels_add_travel_button)
        addTravelButton.setOnClickListener {
            val intent = Intent(this, TravelFormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_travel_list_recyclerView)
        recyclerView.adapter = adapter
    }
}