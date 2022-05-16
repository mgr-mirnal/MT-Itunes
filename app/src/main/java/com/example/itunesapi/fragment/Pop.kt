package com.example.itunesapi.fragment




import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapi.R
import com.example.itunesapi.api.apiService
import com.example.itunesapi.model.songResponse
import com.example.itunesapi.views.SongAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Pop : Fragment() {
    lateinit var rvSongList : RecyclerView
    lateinit var songAdapter: SongAdapter



    fun getSongs(inflater: LayoutInflater, view: View){
        startRetrofit(inflater, apiService.createRetrofit().create(apiService::class.java).getPopSongs())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pop, container, false)
        rvSongList = view.findViewById(R.id.pop_list)
        getSongs(inflater, view)
        return  view
    }

    private fun startRetrofit(inflater: LayoutInflater, call: Call<songResponse>){
        call.enqueue(object : Callback<songResponse> {
            override fun onResponse(
                call: Call<songResponse>,
                response: Response<songResponse>
            ){
                if (response.isSuccessful){
                    songAdapter = SongAdapter(response.body()!!.results)
                    rvSongList.adapter = songAdapter
                }
            }
            override fun onFailure(call : Call<songResponse>, t: Throwable){
                Toast.makeText(inflater.context, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }







}

