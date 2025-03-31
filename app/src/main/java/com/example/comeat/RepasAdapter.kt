package com.example.comeat

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class RepasAdapter(private val lesRepas: List<Repas>): RecyclerView.Adapter<RepasAdapter.RepasViewHolder>() {

    class RepasViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvDate = view.findViewById<TextView>(R.id.tv_date)
        val tvSpec = view.findViewById<TextView>(R.id.tv_specialite)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepasViewHolder {
        val view = LayoutInflater.from( parent.context).inflate(R.layout.item_repas, parent, false)
        return RepasViewHolder(view)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(
        holder: RepasViewHolder,
        position: Int
    ) {
       val repas = lesRepas[position]

        val formateur = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        holder.tvDate.text = repas.date.format(formateur)
        holder.tvSpec.text = repas.specialite.libelle
    }

    override fun getItemCount(): Int {
        return lesRepas.size
    }

}