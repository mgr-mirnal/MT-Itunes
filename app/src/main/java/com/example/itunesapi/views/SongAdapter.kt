package com.example.itunesapi.views

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapi.R
import com.example.itunesapi.model.songs
import com.squareup.picasso.Picasso

class SongAdapter(private val list: List<songs>): RecyclerView.Adapter<SongAdapter.SongViewHolder>(){

    inner class SongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun  onBind(songs: songs){

            val tvSongname : TextView = itemView.findViewById(R.id.tv_song_name)
            val tvArtist : TextView = itemView.findViewById(R.id.tv_artist_name)
            val tvprice: TextView = itemView.findViewById(R.id.tv_price)
            val ivposter: ImageView = itemView.findViewById(R.id.poster)

            tvArtist.text = songs.artistName
            tvSongname.text = songs.trackName
            tvprice.text = "£" + songs.trackPrice
            tvprice.text = tvprice.text.replace("^[$][-].*$".toRegex(),"***Onsale***")

            Picasso.get()
                .load(songs.artworkUrl60)
                .placeholder(R.drawable.ic_launcher_foreground)
                .fit()
                .into(ivposter)

          /*  itemView.setOnClickListener{
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.setDataAndType(Uri.parse(songs.previewUrl),"audio")
                itemView.context.startActivity(intent)
            }
            */
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val listenItem = LayoutInflater.from(parent.context).inflate(R.layout.fragment_musicview,parent,false)
        return SongViewHolder(listenItem)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
