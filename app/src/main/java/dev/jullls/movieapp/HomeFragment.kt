package dev.jullls.movieapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerViewNowShowing: RecyclerView
    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var filmListNowShowing: ArrayList<Film>
    private lateinit var filmListPopular: ArrayList<Film>
    private lateinit var filmAdapterNowShowing: NowShowingFilmAdapter
    private lateinit var filmAdapterPopular: PopularFilmAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            val nowShowingBtn = seeMoreNowShowing
            nowShowingBtn.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_homeFragment_to_detailFragment)
            }
        }
    }

    private fun setupUI(){
        with(binding) {

            recyclerViewNowShowing = nowShowing
            recyclerViewNowShowing.setHasFixedSize(true)
            recyclerViewNowShowing.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            filmListNowShowing = ArrayList()

            recyclerViewPopular = popular
            recyclerViewPopular.setHasFixedSize(true)
            recyclerViewPopular.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            filmListPopular = ArrayList()

            filmListNowShowing.add(
                Film(
                    R.drawable.film_1,
                    "Spiderman: No Way Home",
                    "9.1/10 IMDb",
                    listOf(""),
                    ""
                )
            )
            filmListNowShowing.add(
                Film(
                    R.drawable.film_2,
                    "Eternals",
                    "9.5/10 IMDb",
                    listOf(""),
                    ""
                )
            )
            filmListNowShowing.add(
                Film(
                    R.drawable.film_3,
                    "Shang-Chi",
                    "8,1/10 IMDb",
                    listOf(""),
                    ""
                )
            )

            filmListPopular.add(
                Film(
                    R.drawable.film_4,
                    "Venom Let There Be Carnage",
                    "6.4/10 IMDb",
                    listOf(""),
                    "1h 47m"
                )
            )
            filmListPopular.add(
                Film(
                    R.drawable.film_5,
                    "The King’s Man",
                    "8.4/10 IMDb",
                    listOf(""),
                    "1h 47m"
                )
            )

            filmAdapterNowShowing = NowShowingFilmAdapter(filmListNowShowing)
            filmAdapterPopular = PopularFilmAdapter(filmListPopular)
            recyclerViewNowShowing.adapter = filmAdapterNowShowing
            recyclerViewPopular.adapter = filmAdapterPopular
        }
    }
}