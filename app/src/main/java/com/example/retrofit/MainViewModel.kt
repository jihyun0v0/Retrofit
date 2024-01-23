package com.example.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.ServicePool.healthCheckService
import com.example.retrofit.ServicePool.reqresService
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    val _followers = MutableLiveData<List<Follower>>()
    val followers: MutableLiveData<List<Follower>>
        get() = _followers

    fun loadFollowers() {
        viewModelScope.launch {
            kotlin.runCatching {
                reqresService.getFollowerList()
            }.onSuccess {
                Log.d("server success", it.toString())
            }.onFailure {
                Log.d("server connection fail", it.toString())
            }
        }
    }

    fun healthCheck() {
        viewModelScope.launch {
            kotlin.runCatching {
                healthCheckService.checkHealth()
            }.onSuccess {
                Log.d("health check success", it.toString())
            }.onFailure {
                Log.d("server connection fail", it.toString())
            }
        }
    }
}