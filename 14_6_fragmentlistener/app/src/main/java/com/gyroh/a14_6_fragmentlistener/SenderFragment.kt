package com.gyroh.a14_6_fragmentlistener

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.gyroh.a14_6_fragmentlistener.databinding.FragmentRecieverBinding
import com.gyroh.a14_6_fragmentlistener.databinding.FragmentSenderBinding


class SenderFragment : Fragment() {

    lateinit var binding: FragmentSenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSenderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnYes.setOnClickListener {
                //request라는 키로 전송할거고 두번째 값은 값을 묶어서 보냄 (번들에다가)
                val bundle = bundleOf("" to "Yes")
                setFragmentResult("request",bundle)
            }
            btnNo.setOnClickListener {
                val bundle = bundleOf("" to "No")
                setFragmentResult("request",bundle)
            }
        }
    }
}