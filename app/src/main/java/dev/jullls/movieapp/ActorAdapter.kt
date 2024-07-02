package dev.jullls.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter(private val castList: List<Actor>):
    RecyclerView.Adapter<ActorAdapter.CastViewHolder>() {

    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val castImageView: ImageView = itemView.findViewById(R.id.detail_movie_cast_item_image)
        val castName: TextView = itemView.findViewById(R.id.detail_movie_cast_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.detail_movie_layout, parent, false)
        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return castList.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = castList[position]
        holder.castImageView.setImageResource(cast.image)
        holder.castName.text = cast.name

    }
}