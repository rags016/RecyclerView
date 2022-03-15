package com.learning.servicesexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.servicesexample.R
import com.learning.servicesexample.models.Service


class ServiceAdapter(val context: Context, itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
    var listOfService: List<Service>? = null
    var serviceItemsAdapter = ServiceItemsAdapter()
    val listener: ItemClickListener = itemClickListener
    var upDownFlag = false

    inner class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private val serviceName = view.findViewById<TextView>(R.id.service_title)
        private val serviceTime = view.findViewById<TextView>(R.id.service_time)
        val serviceItemsRV = view.findViewById<RecyclerView>(R.id.service_items_rv)

        fun bindData(service: Service) {
            serviceName.text = service.serviceName
            this.serviceTime.text = service.serviceTime
        }

        override fun onClick(view: View?) {
            if (view != null) {
                var showHideAll = view.findViewById<ImageView>(R.id.show_hide_all)
                if(upDownFlag){
                    showHideAll.setImageDrawable(context.getDrawable(R.drawable.arrow_down_24))
                }else{
                    showHideAll.setImageDrawable(context.getDrawable(R.drawable.arrow_up_24))
                }
                upDownFlag = upDownFlag.not()
                listener.onItemClickListener(view, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.service_days_items, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        listOfService?.get(position)?.let { holder.bindData(it) }
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        holder.serviceItemsRV.layoutManager = layoutManager
        holder.serviceItemsRV.setHasFixedSize(true)
        serviceItemsAdapter.serviceItemsList = listOfService?.get(position)?.days
        holder.serviceItemsRV.adapter = serviceItemsAdapter
    }

    override fun getItemCount(): Int {
        listOfService?.let {
            return it.size
        }
        return 0
    }

    interface ItemClickListener {
        fun onItemClickListener(view: View, position: Int)
    }
}