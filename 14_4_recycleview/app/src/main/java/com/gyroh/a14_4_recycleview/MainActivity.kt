package com.gyroh.a14_4_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gyroh.a14_4_recycleview.databinding.ActivityMainBinding
import com.gyroh.a14_4_recycleview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터를 불러온다.  ...내가 사용할 data를 loadData()함수로 호출해서 가상의 데이터 만들어줌
        val data = loadData()
        // 2. 아답터를 생성
        val customAdapter = CustomAdapter(data)
        // 3. 화면과 RecyclerView와 연결
        binding.recyclerView.adapter = customAdapter
        // 4. 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


    }

    fun loadData() : MutableList<Memo>{
        val memoList = mutableListOf<Memo>()
        for(no in 1..100){
            val title = "이것이 안드로이드다! $no"
            val date = System.currentTimeMillis()
            val memo = Memo(no,title,date)
            memoList.add(memo)
        }
        return memoList
    }

}

class CustomAdapter(val listData:MutableList<Memo>):RecyclerView.Adapter<CustomAdapter.Holder>(){
//커스텀 어댑터르 제네릭으로 홀더를 사용
//    있어야 하기 때문에 홀더 클래스를 만든다.
//    제네릭에다가 홀더를 넣어줌

   //어탭터를 생성할때 listData를 넘겨줌 (val -> 전역변수처럼 쓸수 있음)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        // 고정 항상 이렇게 쓰임 위의 inflate 형식 외우기
        return Holder(binding) // Holder클래스 생성자가 쓰는 binding을 전달함
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 1. 먼저 사용할 데이터를 꺼내고
        val memo = listData.get(position)
        // 2. 홀더에 데이터를 전달
        holder.setMemo(memo)
    }

//    override fun getItemCount(): Int {
//        return listData.size
//    }
    override fun getItemCount() = listData.size  //이렇게 코틀린에서는 한줄로 가능 //목록의 사이즈 리턴

    class Holder(val binding:ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){
//리사이클러뷰의 뷰 홀더를 상속 받는데 상속받을때 생성자로 사용하는 뷰를 넘겨줘야해서
//        뷰바인딩을 전달 binding : Item_recyler.xml에서 쓰기 때문에 IntemRecyclerBinding을 넘겨주고
//        binding.root를 생성자로 넘겨준다.

        // 화면에 한행한행이 뿌려질때 그 장소에서 사용한 데이터를 변수를 만들어서 사용해주면 좋음
        lateinit var currentMemo:Memo //항상 담긴다면 'var currentMemo:Memo? = null' 말고 lateinit선언

        //*클릭 처리는 init에서만 해야한다.*
        init {
            binding.root.setOnClickListener{
                // val title = binding.textTitle.text  -> 이렇게 꺼내는게 아니라 위에 선언된 lateinit을 끌어다씀
                Toast.makeText(binding.root.context,"클릭된 아이템 : ${currentMemo.title}", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. 받은 데이터를 화면에 출력
        fun setMemo(memo:Memo){

            currentMemo = memo  //memo를 담아줌

            with(binding){
                textNo.text = "${memo.no}"
                textTitle.text = memo.title

                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val formattedDate = sdf.format(memo.timestamp)
                textDate.text = formattedDate
            }


        }
    }
}


