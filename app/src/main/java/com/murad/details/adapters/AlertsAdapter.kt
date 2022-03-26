package com.murad.details.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murad.cmon.R
import com.murad.details.model.Alerts
import com.murad.details.view.detailsFragment
import kotlinx.android.synthetic.main.alerts.view.*

class AlertsAdapter (val detais_fargment : detailsFragment , val onClickView : OnClickView)  : RecyclerView.Adapter<AlertsAdapter.AlertsViewHolder>(){


    var alerts : ArrayList<Alerts> = ArrayList<Alerts>()


    fun initiateAlerts(alerts : ArrayList<Alerts>){
        this.alerts = alerts
        /**
         * it's not the best way to use notifyDataSetChanged ,
         * there is another efficient way call defused or or something like that use it
         */
        notifyDataSetChanged()
    }

    interface OnClickView{

        fun onClickView(s:String)
    }

    class AlertsViewHolder(val view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alerts,parent,false)

        return AlertsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlertsViewHolder, position: Int) {
        val alert = alerts[position]
        holder.view.textView28.text=alert.alertId.toString()
        holder.view.system.text = alert.system
        holder.view.subsystem.text = alert.subsystem
        holder.view.ip.text = alert.ip
        holder.view.time.text =alert.startTime
        holder.view.desc.text = alert.description
        holder.view.severity.text = alert.severity

        holder.view.imageView9.setOnClickListener {
            onClickView.onClickView(alert.alertId.toString())
        }
        holder.view.imageView7.setOnClickListener {
            onClickView.onClickView(alert.alertId.toString())
        }

    }

    override fun getItemCount(): Int {
        return alerts.size
    }
}