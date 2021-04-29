package com.example.myapplication.Kotlin

// TV 클래스
// - on/off 기능
// - 채널을 돌리는 기능
// - 초기 채널은 (S사 M사 K사 3개)


fun main(array:Array<String>){


    val tv:TV=TV(listOf<String>("K", "M", "S"))
    tv.swich()
    println(tv.onOroff)
    tv.swich()
    println(tv.onOroff)
    tv.swich()
    println(tv.onOroff)

    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())
    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())
    tv.chaanelsDown()
    println(tv.checkCurrentChaanel())
    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())
    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())
    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())
    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())
    tv.chaanelsUp()
    println(tv.checkCurrentChaanel())

}


class TV(val cannels:List<String>){

    var onOroff:Boolean=false // ture->on, false->off
    var currentChannelNumber=0
        set(value) { //currentChannelNumber의 상태를 계속 확인, (변수에 값이 할당될 때)
            field=value // 무한루프 피할 수 있는 키워드 = field
            // currentChannelNumber=value  변수에 직접 선언하면 안된다 -> 무한루프
            if(field>2){
                field=0
            }
            if(field<0){
                field=2
            }
        }
        get(){ // (변수가 호출되었을 때)
            println("호출되었습니다")
            return field
        }


    fun swich(){
        onOroff=!onOroff
    }

    fun chaanelsUp() {
        currentChannelNumber = currentChannelNumber + 1
        //cannels.forEachIndexed { index, value ->
        //    if (currentChannelNumber == index) {
        //        currentChannelNumber = currentChannelNumber + 1
        //        return
        //    }
        //}
    }

    fun checkCurrentChaanel():String{
        return cannels[currentChannelNumber]
    }

    fun chaanelsDown() {
        currentChannelNumber = currentChannelNumber - 1
        //cannels.forEachIndexed { index, value ->
        //    if (currentChannelNumber == index) {
        //        currentChannelNumber = currentChannelNumber - 1
        //        return
        //    }
        //}
    }


}

