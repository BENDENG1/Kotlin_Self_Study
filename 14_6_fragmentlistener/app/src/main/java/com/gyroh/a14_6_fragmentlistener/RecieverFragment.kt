package com.gyroh.a14_6_fragmentlistener

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.gyroh.a14_6_fragmentlistener.databinding.FragmentRecieverBinding


class RecieverFragment : Fragment() {

    lateinit var binding: FragmentRecieverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecieverBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request"){ key, bundle ->
            bundle.getString("senderKey").let{ value ->
                binding.textView.text = value
            }
        }
    }
}