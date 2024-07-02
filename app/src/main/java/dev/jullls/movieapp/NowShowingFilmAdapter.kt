package dev.jullls.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NowShowingFilmAdapter(private val filmList: List<Film>):
    RecyclerView.Adapter<NowShowingFilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val filmImageView: ImageView = itemView.findViewById(R.id.film_item_poster_nv)
        val filmName: TextView = itemView.findViewById(R.id.film_item_name_nv)
        val filmRating: TextView = itemView.findViewById(R.id.film_item_rating_nv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.now_showing_recyclerview_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        holder.filmImageView.setImageResource(film.filmImage)
        holder.filmName.text = film.filmName
        holder.filmRating.text = film.filmRating
    }
}