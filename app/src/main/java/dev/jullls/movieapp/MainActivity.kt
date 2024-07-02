package dev.jullls.movieapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewNowShowing: RecyclerView
    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var recyclerViewDetailMovieCast: RecyclerView
    private lateinit var filmListNowShowing: ArrayList<Film>
    private lateinit var filmListPopular: ArrayList<PopularFilms>
    private lateinit var castListDetailMovie: ArrayList<Actor>
    private lateinit var filmAdapterNowShowing: NowShowingFilmAdapter
    private lateinit var filmAdapterPopular: PopularFilmAdapter
    private lateinit var castAdapterDetailMovie: ActorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()

        var nowShowingBtn: Button = findViewById(R.id.see_more_now_showing)
        nowShowingBtn.setOnClickListener {
            setContentView(R.layout.detail_movie_layout)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_movie)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            recyclerViewDetailMovieCast = findViewById(R.id.detail_movie_cast_recycler_view)
            recyclerViewDetailMovieCast.setHasFixedSize(true)
            recyclerViewDetailMovieCast.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            castListDetailMovie = ArrayList()

            castListDetailMovie.add(Actor(R.drawable.cast_1, "Tom Holland"))
            castListDetailMovie.add(Actor(R.drawable.cast_2, "Zendaya"))
            castListDetailMovie.add(Actor(R.drawable.cast_3, "Benedict Cumberbatch"))
            castListDetailMovie.add(Actor(R.drawable.cast_4, "Jacon Batalon"))

            castAdapterDetailMovie = ActorAdapter(castListDetailMovie)
            recyclerViewDetailMovieCast.adapter = castAdapterDetailMovie
        }
    }

    private fun init(){
        recyclerViewNowShowing = findViewById(R.id.now_showing)
        recyclerViewNowShowing.setHasFixedSize(true)
        recyclerViewNowShowing.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        filmListNowShowing = ArrayList()

        recyclerViewPopular = findViewById(R.id.popular)
        recyclerViewPopular.setHasFixedSize(true)
        recyclerViewPopular.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        filmListPopular = ArrayList()

        addDataToList()

        filmAdapterNowShowing = NowShowingFilmAdapter(filmListNowShowing)
        filmAdapterPopular = PopularFilmAdapter(filmListPopular)
        recyclerViewNowShowing.adapter = filmAdapterNowShowing
        recyclerViewPopular.adapter = filmAdapterPopular
    }

    private fun addDataToList(){
        filmListNowShowing.add(Film(R.drawable.film_1, "Spiderman: No Way Home", "9.1/10 IMDb"))
        filmListNowShowing.add(Film(R.drawable.film_2, "Eternals","9.5/10 IMDb"))
        filmListNowShowing.add(Film(R.drawable.film_3, "Shang-Chi", "8,1/10 IMDb"))

        filmListPopular.add(PopularFilms(R.drawable.film_4, "Venom Let There Be Carnage", "6.4/10 IMDb", "1h 47m"))
        filmListPopular.add(PopularFilms(R.drawable.film_5, "The King’s Man", "8.4/10 IMDb", "1h 47m"))
    }
}