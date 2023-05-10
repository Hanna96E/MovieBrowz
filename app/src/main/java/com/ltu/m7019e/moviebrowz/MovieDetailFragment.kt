package com.ltu.m7019e.moviebrowz

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ltu.m7019e.moviebrowz.database.MovieDatabase
import com.ltu.m7019e.moviebrowz.database.MovieDatabaseDao
import com.ltu.m7019e.moviebrowz.databinding.FragmentMovieDetailBinding
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.utils.Constants
import com.ltu.m7019e.moviebrowz.viewmodel.MovieDetailViewModel
import com.ltu.m7019e.moviebrowz.viewmodel.MovieDetailViewModelFactory


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailFragment : Fragment() {

    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var viewModelFactory: MovieDetailViewModelFactory

    private lateinit var movieDatabaseDao: MovieDatabaseDao

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        movie = MovieDetailFragmentArgs.fromBundle(requireArguments()).movie
        val application = requireNotNull(this.activity).application
        movieDatabaseDao = MovieDatabase.getInstance(application).movieDatabaseDao


        viewModelFactory = MovieDetailViewModelFactory(movieDatabaseDao, application, movie)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieDetailViewModel::class.java)

        binding.movie = movie
        binding.viewModel = viewModel

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovieDetails(movie)
        binding.imdbLink.setOnClickListener{
            val url = Constants.IMDB_BASE_URL + viewModel.movieDetail.value?.imdbId
            try{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            catch (e: android.content.ActivityNotFoundException){
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setMessage(R.string.invalid_url)
                        setNegativeButton(R.string.ok
                        ) { _, _ ->
                            // User cancelled the dialog
                        }
                    }
                    // Create the AlertDialog
                    builder.create()
                }
                alertDialog?.show()
            }
        }

        binding.homepageLink.setOnClickListener{
            val url = viewModel.movieDetail.value?.homepage
            try{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            catch (e: android.content.ActivityNotFoundException){
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setMessage(R.string.invalid_homepage)
                        setNegativeButton(R.string.ok
                        ) { _, _ ->
                            // User cancelled the dialog
                        }
                    }
                    // Create the AlertDialog
                    builder.create()
                }
                alertDialog?.show()
            }
        }

        binding.backToMovieList.setOnClickListener {
            findNavController().navigate(MovieDetailFragmentDirections.actionMovieDetailFragmentToMovieListFragment())
        }

        binding.movieReview.setOnClickListener {
            findNavController().navigate(MovieDetailFragmentDirections.actionMovieDetailFragmentToMovieReviewFragment(movie))
        }
    }
}