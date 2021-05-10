package com.example.week4_kyj

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TwoFragment : Fragment(){

    override fun onAttach(context: Context) {
        Log.d("Life_cycle","F onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life_cycle","F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Life_cycle","F onCreateView")

        //val binding = FragmentOneBinding = FragmentOneBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_two,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life_cycle","F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life_cycle","F onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Life_cycle","F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life_cycle","F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life_cycle","F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life_cycle","F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Life_cycle","F onDestroyView")
        //oneFragmentBinding = null
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Life_cycle","F onDetach")
        super.onDetach()
    }
}