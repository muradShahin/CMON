package com.murad.details.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murad.cmon.R
import com.murad.details.model.Alerts
import com.murad.details.model.People
import com.murad.details.view.detailsFragment
import kotlinx.android.synthetic.main.alerts.view.*
import kotlinx.android.synthetic.main.people_call_message.view.*

class PeopleAdapter (val detais_fargment : detailsFragment , val onClickView : OnClickView)  : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){


    var peopleList : ArrayList<People> = ArrayList<People>()


    fun initiatePeople(peopleAr : ArrayList<People>){
        this.peopleList = peopleAr
        /**
         * it's not the best way to use notifyDataSetChanged ,
         * there is another efficient way call defused or or something like that use it
         */
        notifyDataSetChanged()
    }

    interface OnClickView{

        fun onPhoneClick(phone:String)
        fun onChatClick(id:Int , name:String)
    }

    class PeopleViewHolder(val view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.people_call_message,parent,false)

        return PeopleViewHolder(view)
    }



    override fun getItemCount(): Int {
        return peopleList.size
    }


    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {

        var person = peopleList[position]
        holder.view.textView30.text = person.name
        holder.view.call_person.setOnClickListener {
            onClickView.onPhoneClick(person.phone)

        }

        holder.view.chat.setOnClickListener {
            onClickView.onChatClick(person.id,person.name)
        }

    }
}