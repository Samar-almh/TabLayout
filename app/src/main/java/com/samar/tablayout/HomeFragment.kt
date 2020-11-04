package com.samar.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  view = inflater.inflate(R.layout.fragment_home, container, false)
        if (param1 == 0) {
            view.text_fragment.text= getString(R.string.home)
            view.home_layout.setBackgroundResource(R.color.pink) }
        else if(param1 == 1){
            view.text_fragment.text= getString(R.string.food)
            view.home_layout.setBackgroundResource(R.color.yellow) }
        else if (param1 == 2){
            view.text_fragment.text= getString(R.string.hotel)
            view.home_layout.setBackgroundResource(R.color.purple) }
        else
        {view.text_fragment.text= getString(R.string.home)}
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}