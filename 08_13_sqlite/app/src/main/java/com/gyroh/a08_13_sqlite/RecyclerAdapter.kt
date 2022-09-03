package com.gyroh.a08_13_sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gyroh.a08_13_sqlite.databinding.ActivityMainBinding
import com.gyroh.a08_13_sqlite.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<Holder>(){
    val listData = mutableListOf<Memo>() //데이터 변수를 미리 정함

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}


class Holder(val binding:ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){
    fun setMemo(memo: Memo) {
        with(binding){
            textNo.text = "${memo.no}"
            textContent.text = memo.content
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            // 날짜 포맷은 SimpleDateFormat을 사용
            val datetime = sdf.format(memo.datetime)
            textDatetime.text = "$datetime"
        }
    }
}

//class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    fun setMemo(memo: Memo) {
//        itemView.textNo.text =
//    }
//}