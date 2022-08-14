package com.example.saturnv1.ui.carta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.saturnv1.databinding.FragmentCartaBinding

class CartaFragment : Fragment() {

    private lateinit var cartaBinding: FragmentCartaBinding
    private lateinit var cartaViewModel: CartaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        cartaViewModel = ViewModelProvider(this)[cartaViewModel::class.java]
        cartaBinding = FragmentCartaBinding.inflate(inflater, container, false)
        val view = cartaBinding.root

        cartaBinding.AddProductActionButton.setOnClickListener{
            findNavController().navigate(CartaFragmentDirections.actionNavigationCartaToNavigationCreate())
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }

}