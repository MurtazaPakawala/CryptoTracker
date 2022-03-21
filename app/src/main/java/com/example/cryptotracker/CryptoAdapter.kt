package com.example.cryptotracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.crypto_item.view.*
import java.util.zip.Inflater

class CryptoAdapter(private val context: Context, private val crypto: List<Crypto>) : RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(context).inflate(R.layout.crypto_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = crypto[position]
        holder.bind(item)
    }

    override fun getItemCount() = crypto.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Crypto) {
            itemView.tvName.text = item.name
            itemView.tvSymbol.text =item.symbol
            itemView.tvPrice.text =item.price.USD.price.toString()

        }
    }
}
