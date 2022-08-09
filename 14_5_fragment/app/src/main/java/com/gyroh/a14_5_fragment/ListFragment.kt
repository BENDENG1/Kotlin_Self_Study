package com.gyroh.a14_5_fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyroh.a14_5_fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {
/*
여기 진짜 미쳤음 다시 공부하셈
 */
    lateinit var binding:FragmentListBinding
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context) //onattach에서 context를 꺼냄 -> 나를 삽입한 Activity가 담겨있음
        if(context is MainActivity) mainActivity = context //context 타입이 MainActivity면
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
//        binding.btnNext.setOnClickListener { mainActivity?.goDetail() } // -> 이렇게 보낼수 있음
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //arguments를 꺼낼수 있음 프래그먼트의 속성임
        with(binding){
            arguments?.apply{
                //nullable일때는 with가 안되므로 apply라는 scope함수를 이용해 가능
                textTitle.text = getString("key1")
                textValue.text = "${getInt("key2")}"
            }
//            textTitle.text = arguments?.getString("key1")
//            textValue.text = "${arguments?.getInt("key2")}"

            btnNext.setOnClickListener {
                mainActivity?.goDetail()
            }
        }
    }

    fun setValue(value:String){
        binding.textFromActivity.text = value
    }
}