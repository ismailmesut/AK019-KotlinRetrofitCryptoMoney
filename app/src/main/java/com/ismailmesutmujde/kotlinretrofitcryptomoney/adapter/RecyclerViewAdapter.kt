package com.ismailmesutmujde.kotlinretrofitcryptomoney.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ismailmesutmujde.kotlinretrofitcryptomoney.R
import com.ismailmesutmujde.kotlinretrofitcryptomoney.model.CryptoModel

class RecyclerViewAdapter (private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {


    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private val colors: Array<String> = arrayOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")
    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener : Listener) {

            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            val textName = itemView.findViewById<TextView>(R.id.textName)
            val textPrice = itemView.findViewById<TextView>(R.id.textPrice)
            textName.text = cryptoModel.currency
            textPrice.text = cryptoModel.price
            //itemView.text_name.text = cryptoModel.currency
            //itemView.text_price.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], colors, position, listener)
    }
}