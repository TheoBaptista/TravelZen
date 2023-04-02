package br.edu.ifrs.poa.travelzen.ui.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifrs.poa.travelzen.R
import br.edu.ifrs.poa.travelzen.model.Travel


class TravelListAdapter(
    private val context: Context,
    travels: List<Travel>
) : RecyclerView.Adapter<TravelListAdapter.ViewHolder>() {

    private val travels = travels.toMutableList()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val button: Button = itemView.findViewById<Button>(R.id.share_button_travel_item)

        fun bind(travel: Travel) {
            val destiny = itemView.findViewById<TextView>(R.id.destiny_travel_item)
            destiny.text = travel.destiny
            val description = itemView.findViewById<TextView>(R.id.description_travel_item)
            description.text = travel.description
            val rate = itemView.findViewById<TextView>(R.id.rate_travel_item)
            rate.text = travel.rate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.travel_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = travels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val travel = travels[position]
        holder.bind(travel)
        holder.button.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, "teste@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Hey check my travel to ${travel.destiny}")
                putExtra(
                    Intent.EXTRA_TEXT, "My destiny: ${travel.destiny} " +
                            "\nWhat i think about this destiny: ${travel.description}" +
                            "\nMy rating of this destiny: ${travel.rate}"
                )
            }
            holder.itemView.context.startActivity(Intent.createChooser(emailIntent, "Send email"))
        }
    }

    fun update(travels: List<Travel>) {
        this.travels.clear()
        this.travels.addAll(travels)
        notifyDataSetChanged()
    }

}