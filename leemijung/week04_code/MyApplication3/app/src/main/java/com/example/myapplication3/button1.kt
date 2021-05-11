package com.example.myapplication3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class button1 :Fragment() {


    override fun onAttach(context: Context) {
        Log.d("life_cycle", "F onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle", "F onCreateView")

        // fragment가 인터페이스(뷰)를 처음으로 그릴 때 호출됨
        // inflater -> 뷰를 그려주는 역할
        //container -> xml에 들러 붙어야 함. 부모뷰(달라 붙을 곳)
        return inflater.inflate(R.layout.activity_button1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "F onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d("life_cycle", "F onPause")
        super.onPause()
    }
    override fun onStop() {
        Log.d("life_cycle", "F onStop")
        super.onStop()
    }
    override fun onDestroyView() {
        Log.d("life_cycle", "F onDestroyView")
        super.onDestroyView()
    }
    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()
    }


}