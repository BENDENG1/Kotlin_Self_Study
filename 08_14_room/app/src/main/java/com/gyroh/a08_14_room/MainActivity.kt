package com.gyroh.a08_14_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.gyroh.a08_14_room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
//    val helper:RoomHelper? = null
    lateinit var helper:RoomHelper
    lateinit var memoAdapter:RecyclerAdapter
    val memoList = mutableListOf<RoomMemo>()
    lateinit var memoDAO:RoomMemoDAO //코드를 줄이기 위한 팁

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        helper = Room.databaseBuilder(this,RoomHelper::class.java,"room_db")
//            .allowMainThreadQueries() //공부할때만 사용
            .build()
        memoDAO = helper.roomMemoDao() //이렇게 선언하고

        memoAdapter = RecyclerAdapter(memoList)
        refreshAdapter() //함수 구현 해서 아랫것과 위에 주석 정리
//       memoList.addAll(helper.roomMemoDao().getAll())

        with(binding){
            recyclerMemo.adapter = memoAdapter
            recyclerMemo.layoutManager = LinearLayoutManager(this@MainActivity)

            buttonSave.setOnClickListener {
                val content = editMemo.text.toString()
                if(content.isNotEmpty()){
                    val datetime = System.currentTimeMillis()
                    val memo = RoomMemo(content, datetime)
                    editMemo.setText("") //메모를 입력하고 빈칸으로 초기화해주는 코드
                    insertMemo(memo)
//                    memoList.clear()
//                    memoList.addAll(helper.roomMemoDao().getAll())
//                    memoAdapter.notifyDataSetChanged()
                }
            }
        }

    }
    fun insertMemo(memo: RoomMemo){
        CoroutineScope(Dispatchers.IO).launch {
            memoDAO.insert(memo) //memoDAO -> helper.roomMemoDao()
            refreshAdapter()
        }
    }

    fun refreshAdapter() {
        CoroutineScope(Dispatchers.IO).launch {
            memoList.clear()
            memoList.addAll(memoDAO.getAll())
            withContext(Dispatchers.Main){
                memoAdapter.notifyDataSetChanged()
            }
        }
    }
}