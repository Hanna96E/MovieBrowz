package com.ltu.m7019e.moviebrowz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ltu.m7019e.moviebrowz.databinding.VideoListItemBinding
import com.ltu.m7019e.moviebrowz.model.MovieVideo
import com.ltu.m7019e.moviebrowz.utils.Constants

class VideoListAdapter(private val videoClickListener: VideoListClickListener) :  ListAdapter<MovieVideo, VideoListAdapter.ViewHolder>(MovieVideoDiffCallback()){
    class ViewHolder(private var binding: VideoListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieVideo: MovieVideo, videoClickListener: VideoListClickListener) {
            binding.movieVideo = movieVideo
            binding.executePendingBindings()
            binding.clickListener = videoClickListener
            val videoUrl = when (movieVideo.site) {
                "YouTube" -> {
                    Constants.YOUTUBE_VIDEO_BASE_URL_EMBED+movieVideo.key
                }
                "Vimeo" -> {
                    Constants.VIMEO_VIDEO_BASE_URL+movieVideo.key
                }
                else -> {
                    movieVideo.key
                }
            }

            val dataUrl = "<html>" +
                    "<body style=\"background-color:black;\">" +
                    "<iframe width=\"1000\" height=\"600\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen/>" +
                    "</body>" +
                    "</html>"

            val myWebView = binding.video

            val webSettings = myWebView.settings

            webSettings.javaScriptEnabled = true
            myWebView.settings.loadWithOverviewMode = true
            myWebView.settings.useWideViewPort = true
            myWebView.loadData(dataUrl, "text/html", "utf-8")
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = VideoListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), videoClickListener)
    }


}

class MovieVideoDiffCallback : DiffUtil.ItemCallback<MovieVideo>() {
    override fun areItemsTheSame(oldItem: MovieVideo, newItem: MovieVideo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieVideo, newItem: MovieVideo): Boolean {
        return oldItem == newItem
    }

}

class VideoListClickListener(val clickListener: (movieVideo: MovieVideo) -> Unit) {
    fun onClick(movieVideo: MovieVideo) = clickListener(movieVideo)
}