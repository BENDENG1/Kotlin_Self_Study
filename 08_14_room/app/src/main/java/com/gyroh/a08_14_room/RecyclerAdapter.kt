package com.gyroh.a08_14_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gyroh.a08_14_room.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerAdapter(val roomMemoList:List<RoomMemo>) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setMemo(roomMemoList.get(position))
    }

    override fun getItemCount() = roomMemoList.size
//    override fun getItemCount(): Int {
//        return memoList.size
//    }

    class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        fun setMemo(roomMemo: RoomMemo){
            with(binding){
                textNo.text = "${roomMemo.no}"
                textContent.text = "${roomMemo.content}"

                val sdf = SimpleDateFormat("yy/MM/dd hh:mm")
                textDatetime.text = sdf.format(roomMemo.datetime)
            }
        }
    }
}