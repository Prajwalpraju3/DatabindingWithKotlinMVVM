package com.onnet.databinding

import androidx.appcompat.app.AppCompatActivity
import com.onnet.databinding.ListAdapter.ItemClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.onnet.databinding.viewmodels.AuthViewModel
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import com.onnet.databinding.pojo.SingleDataItem
import android.widget.Toast
import com.onnet.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemClickListener {
    var binding: ActivityMainBinding? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var viewModel: AuthViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager!!.orientation = RecyclerView.VERTICAL
        binding!!.rvList.layoutManager = linearLayoutManager
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        viewModel!!.dashboardData.observe(this) { singleDataItems ->
            binding!!.pgBar.visibility = View.GONE
            binding!!.rvList.visibility = View.VISIBLE
            binding!!.rvList.adapter = ListAdapter(singleDataItems, this@MainActivity)
        }
    }



    override fun onItemClicked(item: SingleDataItem?) {
        if (item != null) {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
    }
}