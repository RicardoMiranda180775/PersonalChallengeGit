package com.ricardomiranda.personalchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardomiranda.personalchallenge.adapter.RecyclerViewAdapter
import com.ricardomiranda.personalchallenge.models.RecyclerList
import com.ricardomiranda.personalchallenge.viewmodel.MainActivityViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View){
       val recyclerView =  view.findViewById<RecyclerView>(R.id.recyclerView)
       recyclerView.layoutManager = LinearLayoutManager(activity)
       val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
       recyclerView.addItemDecoration(decoration)


        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(this, Observer<RecyclerList> {
            if(it != null){
                recyclerAdapter.setUpdateData(it.items)
            }else{
                Toast.makeText(activity, "Falha ao recuperar dados...", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }


    companion object {
        @JvmStatic
        fun newInstance() = RecyclerListFragment()
    }
}