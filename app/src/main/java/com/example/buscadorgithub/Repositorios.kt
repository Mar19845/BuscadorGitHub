package com.example.buscadorgithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.buscadorgithub.databinding.FragmentRepositoriosBinding


class Repositorios : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingRepositorios = DataBindingUtil.inflate<FragmentRepositoriosBinding>(inflater,
            R.layout.fragment_repositorios,container,false)
        return bindingRepositorios.root
    }


}
