package com.ricardomiranda.personalchallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ricardomiranda.personalchallenge.R
import com.ricardomiranda.personalchallenge.models.RecyclerData
import com.squareup.picasso.Picasso

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<RecyclerData>()

    fun setUpdateData(items : ArrayList<RecyclerData>){
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){

        val imageAvatar = view.findViewById<ImageView>(R.id.imageAvatar)
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
        val textViewStarQtd = view.findViewById<TextView>(R.id.textViewStarQtd)
        val textViewForkQtd = view.findViewById<TextView>(R.id.textViewForkQtd)
        val textViewFullName = view.findViewById<TextView>(R.id.textViewFullName)

        fun bind(data:RecyclerData){
            textViewTitle.text = data.name
            textViewDescription.text = data.description
            textViewStarQtd.text = "Stars: " + data.stargazers_count
            textViewForkQtd.text = "Forks: " + data.forks_count
            textViewFullName.text = "Full Name: " + data.full_name

            val url = data.owner.avatar_url

            Picasso.get()
                .load(url)
                .into(imageAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false )
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}