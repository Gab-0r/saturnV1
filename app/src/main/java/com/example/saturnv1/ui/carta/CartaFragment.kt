package com.example.saturnv1.ui.carta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.saturnv1.R
import com.example.saturnv1.databinding.FragmentCartaBinding


class CartaFragment : Fragment() {

    private lateinit var cartaBinding: FragmentCartaBinding
    private lateinit var cartaViewModel: CartaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        cartaBinding = FragmentCartaBinding.inflate(inflater, container, false)
        cartaViewModel = ViewModelProvider(this)[cartaViewModel::class.java]

        /*
        cartaBinding.AddProductActionButton.setOnClickListener{
           findNavController().navigate(CartaFragmentDirections.actionNavigationCartaToCreateFragment())
        }

         */

        //return inflater.inflate(R.layout.fragment_carta, container, false)
        return cartaBinding.root
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }

}