package com.gyroh.a14_10_viewpagerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.gyroh.a14_10_viewpagerview.databinding.ActivityMainBinding
import com.gyroh.a14_10_viewpagerview.databinding.ItemViewpagerBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터를 로드
        val list = loadData()
        // 2. 아답터를 생성
        val pagerAdapter = CustomPagerAdapter(list)
        // 3. 아답터와 뷰페이저를 연결
        binding.viewPager.adapter = pagerAdapter

        // 4. 탭 타이틀 목록 생성 - 위의 데이터 사용
        val titles = listOf("월","화","수","목","금","토","일")
        // 5. 탭레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab, position->
            // 컬렉션이나 어레이 같은거는 []로 가능한데 문법 자체가 그다지 좋지 않아서
            // list[position]보다 get(position) 이런식으로 넘기는게 일관성 있으니 참고하기
            tab.text = titles.get(position)
        }.attach() //attach이거 빼먹지 말기ㅋㅋ 이거안하면 연결이 안됨..
    }

    fun loadData() : List<Page> {
        val pageList = mutableListOf<Page>()
        pageList.add(Page(1,"흐림"))
        pageList.add(Page(2,"맑음"))
        pageList.add(Page(3,"구름"))
        pageList.add(Page(4,"비"))
        pageList.add(Page(5,"눈"))
        pageList.add(Page(6,"태풍"))
        pageList.add(Page(7,"안개"))
        return pageList
    }
}

class CustomPagerAdapter(val pageList:List<Page>) : RecyclerView.Adapter<CustomPagerAdapter.Holder>(){
    var testList = listOf<String>()
    class Holder(val binding : ItemViewpagerBinding) : RecyclerView.ViewHolder(binding.root){
        fun setItem(page:Page){
            with(binding){
                textDay.text = "${page.day} 일"
                textWeather.text = page.weather
            }
        }
    }
    override fun getItemCount() = pageList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setItem(pageList.get(position))
    }
}

// 사용할 페이지 데이터클래스 생성
data class Page(val day:Int, val weather:String) {

}



// 여기가 하나로 공부할때
//class MainActivity : AppCompatActivity() {
//
//    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        // 1. 데이터를 로드
//        val list = listOf("월","화","수","목","금","토","일")
//        // 2. 아답터를 생성
//        val pagerAdapter = CustomPagerAdapter(list)
//        // 3. 아답터와 뷰페이저를 연결
//        binding.viewPager.adapter = pagerAdapter
//
//        // 4. 탭 타이틀 목록 생성 - 위의 데이터 사용 (근데 이미 월화수로 되어있음/ 나중에는 내가 설정)
//        // 5. 탭레이아웃과 뷰페이저 연결
//        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab, position->
//            // 컬렉션이나 어레이 같은거는 []로 가능한데 문법 자체가 그다지 좋지 않아서
//            // list[position]보다 get(position) 이런식으로 넘기는게 일관성 있으니 참고하기
//            tab.text = list.get(position)
//        }.attach() //attach이거 빼먹지 말기ㅋㅋ 이거안하면 연결이 안됨..
//    }
//
//}
////페이지 리스트를 넘기니깐 책에서 다르게 String으로 넘김
//class CustomPagerAdapter(val textList:List<String>) : RecyclerView.Adapter<CustomPagerAdapter.Holder>(){
//
//    var testList = listOf<String>()
//
//    class Holder(val binding : ItemViewpagerBinding) : RecyclerView.ViewHolder(binding.root){
//        //꺼내면 항상 스트링 홀더에 설계되는 setItem메서드는
//        fun setItem(text:String){
//            binding.textView.text = text //텍스트뷰에 텍스트를 넘겨준 텍스트로 바꿔줌
//        }
//
//    }
//
//    override fun getItemCount() = textList.size
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        // val binding = -> 이거 이렇게 쓰는거 국룰
//        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(binding)
//    }
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.setItem(textList.get(position))
//    }
//}


