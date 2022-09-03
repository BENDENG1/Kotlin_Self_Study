package com.gyroh.a08_13_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gyroh.a08_13_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val DB_NAME = "sqlite.sql"
    val DB_VERSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val helper = SqliteHelper(this, DB_NAME, DB_VERSION)
        val adapter = RecyclerAdapter()

        val memos = helper.selectMemo()
        adapter.listData.addAll(memos) // addAll : 기존에 데이터가 있으면 추가로 넣음


        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        with(binding){
            btnSave.setOnClickListener {
                val content = editMemo.text.toString()
                if(content.isNotEmpty()){
                    val memo = Memo(null,content,System.currentTimeMillis())
                    helper.insertMemo(memo)
                    // 기존 작성 글 삭제
                    editMemo.setText("")
                    // 목록 갱신  add를 하면 모두 들고오게 되어서 clear해줌
                    // 이거는 무식하게 기존에 있는거 중에 추가 있으면 다 지우고 추가하는거
                    adapter.listData.clear()
                    adapter.listData.addAll(helper.selectMemo())
                    adapter.notifyDataSetChanged()
                }
            }
        }

    }
}