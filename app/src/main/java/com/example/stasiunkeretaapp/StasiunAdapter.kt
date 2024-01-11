package com.example.stasiunkeretaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StasiunAdapter(private val doaList: List<ResponseStasiun>) : RecyclerView.Adapter<StasiunAdapter.DoaViewHolder>() {

    class DoaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNama: TextView = itemView.findViewById(R.id.tv_nama)
        val textViewAlamat: TextView = itemView.findViewById(R.id.tv_alamat)
        val textViewKode: TextView = itemView.findViewById(R.id.tv_kode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kereta, parent, false)
        return DoaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DoaViewHolder, position: Int) {
        val currentDoa = doaList[position]
        holder.textViewNama.text = currentDoa.name
        holder.textViewAlamat.text = currentDoa.cityname
        holder.textViewKode.text = currentDoa.code
    }

    override fun getItemCount(): Int {
        return doaList.size
    }
}