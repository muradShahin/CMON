package com.murad.details.view

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murad.cmon.R
import com.murad.details.adapters.AlertsAdapter
import com.murad.details.adapters.PeopleAdapter
import com.murad.details.model.Alerts
import com.murad.details.model.People
import kotlinx.android.synthetic.main.call_dialog.*
import kotlinx.android.synthetic.main.fragment_details.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class detailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_details, container, false)

        init(view)
        return view
    }

    fun init(view: View){




        val alertsAdapter = AlertsAdapter(this,object :AlertsAdapter.OnClickView{
            override fun onClickView(s: String) {
                showCallDialog()
            }

        })

        view.alerts_rec.apply {
            layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
            adapter = alertsAdapter
        }

        getAlerts(alertsAdapter)

    }

    fun getAlerts(alertsAdapter: AlertsAdapter){

        val alerts = ArrayList<Alerts>()
        val alert1 = Alerts(9871,"Jordan","CMGT","RDC","10.0.53.27","RDC is down","25/03 at 00:45","Critical")
        val alert2 = Alerts(1233,"Jordan","MW","RDC","10.0.53.27","SYSTEM X","25/03 at 00:45","Critical")
        val alert3 = Alerts(4522,"Jordan","Microservices","AWS","10.0.53.27","RDC is down","25/03 at 00:45","Critical")
        val alert4 = Alerts(7811,"Jordan","Reflect","Wallets","10.0.53.27","RDC is down","25/03 at 00:45","Critical")
        val alert5 = Alerts(4478,"Jordan","ATM","SYSTEM ATM X","10.0.53.27","RDC is down","25/03 at 00:45","Critical")
        alerts.add(alert1)
        alerts.add(alert2)
        alerts.add(alert3)
        alerts.add(alert4)
        alerts.add(alert5)

        alertsAdapter.initiateAlerts(alerts)



    }


    fun showCallDialog(){


        val dialog= Dialog(requireContext())
        dialog.setContentView(R.layout.call_dialog)
        dialog.setCancelable(false)


        var peopleAdapter = PeopleAdapter(this,object :PeopleAdapter.OnClickView{
            override fun onPhoneClick(phone: String) {
                /**
                 * call
                 */
            }

            override fun onChatClick(id: Int, name: String) {
                /**
                 * chat
                 */

                findNavController().navigate(R.id.action_detailsFragment_to_chatFragment)
                dialog.dismiss()
            }



        })

        dialog.dismiss.setOnClickListener {
            dialog.dismiss()
        }

        dialog.rec_people.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = peopleAdapter
        }


        peopleAdapter.initiatePeople(getPeople())


        dialog.window?.setBackgroundDrawableResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
        dialog.show()


    }

    fun getPeople() : ArrayList<People>{
        var peopleList = ArrayList<People>()
        var person1 = People(1,"Murad Shahin","Development Specialist","IT","0798557992")
        var person2 = People(1,"Ayham Hammoudeh","Manager","IT","079992123")

        peopleList.add(person1)
        peopleList.add(person2)

        return peopleList
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment detailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            detailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}