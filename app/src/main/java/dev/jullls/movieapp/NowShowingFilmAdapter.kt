package dev.jullls.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.databinding.ItemNowShowingFilmBinding

class NowShowingFilmAdapter(private val filmList: List<Film>):
    RecyclerView.Adapter<NowShowingFilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemNowShowingFilmBinding.bind(view)

        fun bind(film: Film){
            with(binding){
                ivItemNowShowingPoster.setImageResource(film.image)
                tvItemNowShowingName.text = film.name
                tvItemNowShowingRating.text = film.rating
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_now_showing_film, parent, false)
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