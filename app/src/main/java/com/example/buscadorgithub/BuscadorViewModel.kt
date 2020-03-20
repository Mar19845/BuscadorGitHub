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
    private val _responseReceived = MutableLiveData<String>()
    var status = MutableLiveData<Boolean?>()
    private val _propertyGit = MutableLiveData<Repos>()
    val property: LiveData<Repos>
        get() = _propertyGit
    val responder: LiveData<String>
        get() = _responseReceived
    //
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
                _response.value=response.body()
            }
        })
    }
    fun getGitPropertyFromJson(){
        ApiService.service.getProperties(user)?.enqueue(object :retrofit2.Callback<Repos>{
            override fun onFailure(call: Call<Repos>, t: Throwable) {
                _responseReceived.value = "Error " + t.message

            }

            override fun onResponse(call: Call<Repos>, response: Response<Repos>) {
                _responseReceived.value = "Nombre usuario: "+response.body()?.login
                if (response.body()?.login!=null){
                    _responseReceived.value = "Nombre usuario: "+response.body()?.login
                    _propertyGit.value=response.body()
                    status.value=false
                }else{
                    _responseReceived.value = "No existe"
                    status.value = true }
            }
        })
    }
}