package com.example.saturnv1.ui.create

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saturnv1.R
import com.example.saturnv1.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {

    private lateinit var createViewModel: CreateViewModel
    private lateinit var createBinding: FragmentCreateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        createBinding = FragmentCreateBinding.inflate(inflater, container, false)
        createViewModel = ViewModelProvider(this)[createViewModel::class.java]
        val view = createBinding.root

        with(createBinding){
            createproductButton.setOnClickListener{
                createViewModel.validateFields(
                    productnameInputText.text.toString(),
                    producttypeInputText.text.toString(),
                    productpriceInputText.text.toString().toInt(),
                    productdescriptionInputText.text.toString()
                )


            }
        }
        return view
    }
}