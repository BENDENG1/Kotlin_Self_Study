package com.gyroh.a14_5_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyroh.a14_5_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val listFragment by lazy {ListFragment()}
    val detailFragment by lazy {DetailFragment()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragment()

        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }

    }

    fun goDetail(){

//        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail") //뒤로가기를 구현 -> 이게 없으면 액티비티 자체가 종료
        // 프래그먼트의 동작을 스택에 담김 즉 뒤로가기하면 돌아오는 순간 스택에서 제거

        transaction.commit()
    }
    fun goBack(){
        onBackPressed() // -> 뒤로가기 명령어가 담겨있는거 Activity가 가지고 있는 애
    }

    fun setFragment() {
        //intent에 넘길때는 bundle이 있어서 intent.putExtra()로 했는데
        //프래그먼트에 넘길때는 bundle을 명시적으로 한다.
        val bundle = Bundle()
        bundle.putString("key1","list_Fragment")
        bundle.putInt("key2",20220802)
        //값은 add하기전에 값을 넘겨줌
        listFragment.arguments = bundle

        // 1. 사용할 프래그먼트 생성
        // val listFragment: ListFragment = ListFragment()
        // 2. 트랜잭션 생성
        val transaction = supportFragmentManager.beginTransaction()
        // 3. 트랜잭션을 통해 프레그먼트 삽입
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }

}