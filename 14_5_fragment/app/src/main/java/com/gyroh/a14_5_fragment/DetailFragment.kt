package com.gyroh.a14_5_fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyroh.a14_5_fragment.databinding.FragmentDetailBinding
import com.gyroh.a14_5_fragment.databinding.FragmentListBinding


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context) //onattach에서 context를 꺼냄 -> 나를 삽입한 Activity가 담겨있음
        if(context is MainActivity) mainActivity = context //context 타입이 MainActivity면
    }
    //onattach로 detailfragmentn가 붙는순간 메인엑티비티역시 컨텍스트로 담아놓고


    //oncreateview가 되면면 detailbinding으로 binding을 생성하고 담아서 binding의 root
    //view는 안드로이드 한테 전달
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
//        binding.btnNext.setOnClickListener { mainActivity?.goBack() } // -> 이렇게 보낼수 있음
        return binding.root
    }


    // onviewcreated가 되면 btnback에 listenter를 달음
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            mainActivity?.goBack() }
    }
}