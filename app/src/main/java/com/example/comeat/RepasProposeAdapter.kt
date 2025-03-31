package com.example.comeat

import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.time.format.DateTimeFormatter

class RepasProposeAdapter(  private val lesRepas: List<Repas>, private val onItemClickListener: (Repas) -> Unit ) : RecylerView.Adapter<RepasAdapter.RepasViewHolder> (){

    class RepasViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val tvDate = view.findViewById<TextView>(R.id.tvDatePropose)
        val tvSpec = view.findViewById<TextView>(R.id.tvSpePorpose)

        fun bind(repas: Repas, onItemClickListener: (Repas) -> Unit){
            val formateur = DateTimeFormatter
        }

    }


}