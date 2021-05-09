package com.example.myapplication3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentOneweek4:Fragment(){
    override fun onAttach(context: Context) {
        Log.d("life_cycle" ,"onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle" ,"onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle" ,"onCreateView")

        return inflater.inflate(R.layout.fragment_oneweek4,container,false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle" ,"onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle" ,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle" ,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle" ,"onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle" ,"onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle" ,"onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle" ,"onDetach")
        super.onDetach()
    }
}