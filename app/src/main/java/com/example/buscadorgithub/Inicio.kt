package com.example.buscadorgithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.buscadorgithub.databinding.FragmentInicioBinding


class Inicio : Fragment() {

    private lateinit var viewModel: BuscadorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingInicio = DataBindingUtil.inflate<FragmentInicioBinding>(inflater,
            R.layout.fragment_inicio,container,false)

        bindingInicio.botonRepositorios.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_inicio_to_repositorios)
        }
        return bindingInicio.root
    }
}
