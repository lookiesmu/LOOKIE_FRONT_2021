package com.muleo.week5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muleo.week5.databinding.ActivityMainBinding
import com.muleo.week5.db.EventDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflate
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        // adapter
        val adapter = EventAdapter()
        binding.eventRecyclerView.adapter = adapter
        setContentView(view)


        // viewModel
        val dao = EventDatabase.getInstance(application).eventDBDao
        val viewModel = ViewModel(dao)
        viewModel.apply {
            events.observe(this@MainActivity, {
                adapter.data = it
            })
            onDialog.observe(this@MainActivity, {
                Fragment(viewModel).show(supportFragmentManager, Fragment.TAG)
            })
        }

        // fab
        binding.fab.setOnClickListener {
            Fragment(viewModel).show(supportFragmentManager, Fragment.TAG)
        }

    }
}