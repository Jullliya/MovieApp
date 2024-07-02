package dev.jullls.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.databinding.ItemActorBinding

class ActorAdapter(private val actorList: List<Actor>):
    RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemActorBinding.bind(view)

        fun bind(actor: Actor){
            with(binding){
                ivItemActorImage.setImageResource(actor.image)
                tvItemActorName.text = actor.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.detail_movie_layout, parent, false)
        return ActorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = actorList[position]
        holder.bind(actor)
    }
}