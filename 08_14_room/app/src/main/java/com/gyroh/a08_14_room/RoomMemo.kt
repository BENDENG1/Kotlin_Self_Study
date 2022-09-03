package com.gyroh.a08_14_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_memo")
class RoomMemo {
    @PrimaryKey(autoGenerate = true) // no에 값이 없을 때 자동증가된 숫자값을 db에 입력해준다.
    @ColumnInfo
    var no: Long? = null
    @ColumnInfo
    var content : String? = ""
    @ColumnInfo
    var datetime:Long = 0

    constructor(content:String, datetime:Long){
        this.content = content
        this.datetime = datetime
        /* @TIP
        클래스를 나중에
        val memo = RoomMemo()
        memo.content = ""
        memo.datetime = 1412312 이렇게 하는데
        아래처럼 생성자를 활용하게 된다면
        val memo = RoomMemo ( content : "메모", ..) 이런식으로 사용하기 편해진다.
         */
    }


}
