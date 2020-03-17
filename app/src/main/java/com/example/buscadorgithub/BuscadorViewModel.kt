package com.example.buscadorgithub

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buscadorgithub.data.ApiService
import retrofit2.Call
import retrofit2.Response

class BuscadorViewModel : ViewModel() {
    var user:String=""
    private var _response = MutableLiveData<List<Repos>>()
    var brt:Boolean=false
    val responsa: LiveData<List<Repos>>
        get() = _response

    fun getRepos(){
        ApiService.service.listRepos(user)?.enqueue(object:retrofit2.Callback<List<Repos>>{

            override fun onFailure(call: Call<List<Repos>>, t: Throwable) {
                Log.i("Fallo","${t.message}")
            }
            override fun onResponse(call: Call<List<Repos>>, response: Response<List<Repos>>) {
                _response.value=response.body()!!
            }
        })
    }
}



