package dev.jullls.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.databinding.ItemPopularFilmBinding

class PopularFilmAdapter(private val filmList: List<Film>):
    RecyclerView.Adapter<PopularFilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemPopularFilmBinding.bind(view)

        fun bind(film: Film){
            with(binding){
                ivItemPopularPoster.setImageResource(film.image)
                tvItemPopularName.text = film.name
                tvItemPopularRating.text = film.rating
                tvItemPopularDuration.text = film.duration
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_popular_film, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        holder.bind(film)
    }
}