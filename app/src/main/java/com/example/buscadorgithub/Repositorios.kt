package com.example.buscadorgithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buscadorgithub.databinding.FragmentRepositoriosBinding


class Repositorios : Fragment() {
    private lateinit var viewModel: BuscadorViewModel
    private lateinit var listas:List<Repos>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = BuscadorViewModel()
        val bindingRepositorios = DataBindingUtil.inflate<FragmentRepositoriosBinding>(inflater,
            R.layout.fragment_repositorios,container,false)
        var RecyclerView: RecyclerView
        var adaptador= Adapter(context!!)
        viewModel= ViewModelProviders.of(activity!!).get(BuscadorViewModel::class.java)
        RecyclerView=bindingRepositorios.recycler
        RecyclerView.layoutManager= LinearLayoutManager(context)
        bindingRepositorios.lifecycleOwner=viewLifecycleOwner
        viewModel.getRepos()
        viewModel.responsa.observe(viewLifecycleOwner, Observer {
            listas=listas
            adaptador.setRepos(listas)
        })


        return bindingRepositorios.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(BuscadorViewModel::class.java)

    }


}
