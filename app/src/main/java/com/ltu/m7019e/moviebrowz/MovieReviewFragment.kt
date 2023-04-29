package com.ltu.m7019e.moviebrowz

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ltu.m7019e.moviebrowz.adapter.*
import com.ltu.m7019e.moviebrowz.database.MovieDatabase
import com.ltu.m7019e.moviebrowz.database.MovieDatabaseDao
import com.ltu.m7019e.moviebrowz.databinding.FragmentMovieReviewBinding
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.network.DataFetchStatus
import com.ltu.m7019e.moviebrowz.viewmodel.MovieReviewViewModel
import com.ltu.m7019e.moviebrowz.viewmodel.MovieReviewViewModelFactory


/**
 * A simple [Fragment] subclass.
 */
class MovieReviewFragment : Fragment() {

    private lateinit var viewModel: MovieReviewViewModel
    private lateinit var viewModelFactory: MovieReviewViewModelFactory

    private lateinit var movieDatabaseDao: MovieDatabaseDao

    private var _binding: FragmentMovieReviewBinding? = null
    private val binding get() = _binding!!

    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieReviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        movie = MovieReviewFragmentArgs.fromBundle(requireArguments()).movie

        val application = requireNotNull(this.activity).application
        movieDatabaseDao = MovieDatabase.getInstance(application).movieDatabaseDao

        viewModelFactory = MovieReviewViewModelFactory(movieDatabaseDao, application, movie)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieReviewViewModel::class.java)

        viewModel.dataFetchStatusReviews.observe(viewLifecycleOwner) { status ->
            status?.let {
                when (status) {
                    DataFetchStatus.LOADING -> {
                        binding.reviewStatusImage.visibility = View.VISIBLE
                        binding.reviewStatusImage.setImageResource(R.drawable.loading_animation)
                    }
                    DataFetchStatus.ERROR -> {
                        binding.reviewStatusImage.visibility = View.VISIBLE
                        binding.reviewStatusImage.setImageResource(R.drawable.ic_connection_error)
                    }
                    DataFetchStatus.DONE -> {
                        binding.reviewStatusImage.visibility = View.GONE
                    }
                }
            }
        }

        viewModel.dataFetchStatusVideos.observe(viewLifecycleOwner) { status ->
            status?.let {
                when (status) {
                    DataFetchStatus.LOADING -> {
                        binding.videoStatusImage.visibility = View.VISIBLE
                        binding.videoStatusImage.setImageResource(R.drawable.loading_animation)
                    }
                    DataFetchStatus.ERROR -> {
                        binding.videoStatusImage.visibility = View.VISIBLE
                        binding.videoStatusImage.setImageResource(R.drawable.ic_connection_error)
                    }
                    DataFetchStatus.DONE -> {
                        binding.videoStatusImage.visibility = View.GONE
                    }
                }
            }
        }

        val movieReviewAdapter = ReviewListAdapter()
        val movieVideoAdapter = VideoListAdapter(VideoListClickListener { movieVideo ->
            viewModel.onVideoListItemClicked(movieVideo)
        })

        binding.movie = movie
        binding.reviewListRv.adapter = movieReviewAdapter
        binding.videoListRv.adapter = movieVideoAdapter

        viewModel.movieReviewList.observe(viewLifecycleOwner) { reviewList ->
            reviewList?.let {
                movieReviewAdapter.submitList(reviewList)
            }
        }

        viewModel.movieVideoList.observe(viewLifecycleOwner) { videoList ->
            videoList?.let {
                movieVideoAdapter.submitList(videoList)
            }
        }

        viewModel.videoLink.observe(viewLifecycleOwner, Observer { url ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            try {
                startActivity(browserIntent)
            } catch (e: ActivityNotFoundException) {
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setMessage(R.string.invalid_url)
                        setNegativeButton(
                            R.string.ok
                        ) { _, _ ->
                            // User cancelled the dialog
                        }
                    }
                    // Create the AlertDialog
                    builder.create()
                }
                alertDialog?.show()
            }
        })

        binding.viewModel = viewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewModel.getReviews(movie)
        viewModel.getVideos(movie)

        binding.backToMovieDetail.setOnClickListener {
            findNavController().navigate(MovieReviewFragmentDirections.actionMovieReviewFragmentToMovieDetailFragment(movie))
        }

    }

}
