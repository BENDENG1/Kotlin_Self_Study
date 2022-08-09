package com.gyroh.viewpagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.gyroh.viewpagerfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 페이지 데이터를 로드
        val list = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        // 2. 아답터를 생성
        val pagerAdapter = FragmentPagerAdapter(list, this)
        with(binding){
            // 3. 아답터와 뷰 페이저를 연결
            viewPager.adapter = pagerAdapter

            // 코드에서 탭 레이아웃을 구성
            // 4. 탭 메뉴의 개수만큼 제목을 목록으로 생성
            val titles = listOf("A","B","C","D")
            // 5. 탭레이아웃과 뷰 페이저 연결
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                //뷰 페이저를 탭레이아웃에 넘겨주면 탭 레이아웃과 뷰페이저의 갯수의 스코프만큼 갯수를 반복하고 탭을 생성하고 그게 몇번째인지 알려줌
                //타이틀에 있는 텍스트를 넣어주기만 하면 됨
                tab.text = titles.get(position)
            }.attach() //attach() -> 호출하여야 정상적 동작
        }
    }
}


// FragmentStateAdapter의 상속을 받음
// 상속받은 부모 클래스 생성자의 파라미터를 넘겨주기 위해 자식의 생성자의 프래그먼트 액티비티를 받아서 넘겨줌
// 리사이클러 아답터와 비슷함 첫번째 아이템 갯수, 두번째는 크레이트 뷰홀더와 비슷하다고 생각하면 됨
class FragmentPagerAdapter(val fragmentList:List<Fragment>, fragmentActivity: FragmentActivity)
                                                    : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() =  fragmentList.size
    override fun createFragment(position: Int) = fragmentList.get(position)
}