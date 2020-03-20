package com.example.buscadorgithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.buscadorgithub.databinding.FragmentInicioBinding


class Inicio : Fragment() {

    private lateinit var viewModel: BuscadorViewModel
    var boolean:Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = BuscadorViewModel()
        val bindingInicio = DataBindingUtil.inflate<FragmentInicioBinding>(inflater,
            R.layout.fragment_inicio,container,false)


        bindingInicio.botonRepositorios.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_inicio_to_repositorios)
        }
        bindingInicio.botonBuscar.setOnClickListener {
            viewModel.user = bindingInicio.Buscador.text.toString()
            viewModel.getGitPropertyFromJson()
        }
        viewModel.status.observe(viewLifecycleOwner, Observer { status ->
            status?.let {
                viewModel.status.value = null
                if(status==false){
                    bindingInicio.Ejemplo.setText(viewModel.user)
                    boolean=true
                }else if(status==true){
                    bindingInicio.Ejemplo.setText("no se trabo ")
                    boolean=false
                    Toast.makeText(activity,"No se pudo encontrar un usuario con ese nombre", Toast.LENGTH_SHORT).show()
                }
            }
        })
        return bindingInicio.root
    }
}
