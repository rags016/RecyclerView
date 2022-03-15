package com.learning.servicesexample.viewmodels

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.servicesexample.Utils
import com.learning.servicesexample.adapters.ServiceAdapter
import com.learning.servicesexample.models.Service

class ServiceViewModel(private val context: Application) : ViewModel(),
    ServiceAdapter.ItemClickListener {
    private val serviceAdapter = ServiceAdapter(context, this)
    private var serviceList = mutableListOf<Service>()
    val progress = MutableLiveData(true)

    fun fetchData() {
        progress.value = true
        val dataAsString = Utils.getServesDataFromAssets(context, fileName)
        val gson = Gson()
        val data = object : TypeToken<List<Service>>() {}.type
        serviceList = gson.fromJson(dataAsString, data)
        setDataInAdapter(serviceList)
    }

    private fun setDataInAdapter(serviceList: MutableList<Service>) {
        serviceAdapter.listOfService = serviceList
        progress.value = false
    }

    fun getAdapter(): ServiceAdapter {
        return serviceAdapter
    }

    override fun onItemClickListener(view: View, position: Int) {
        //onClick will be handled
    }

    companion object {
        const val fileName = "ServiceData.json"
    }
}