package com.learning.servicesexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.servicesexample.models.Day
import com.learning.servicesexample.R

class ServiceItemsAdapter : RecyclerView.Adapter<ServiceItemsAdapter.ServiceItemsViewHolder>() {
    var serviceItemsList: List<Day>? = null

    class ServiceItemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayName = view.findViewById<TextView>(R.id.service_day)
        val dayTime = view.findViewById<TextView>(R.id.service_day_time)
        fun bindData(day: Day?) {
            dayName.text = day?.day
            dayTime.text = day?.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_items, parent, false)
        return ServiceItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceItemsViewHolder, position: Int) {
        holder.bindData(serviceItemsList?.get(position))
    }

    override fun getItemCount(): Int {
        serviceItemsList?.let {
            return it.size
        }
        return 0
    }
}