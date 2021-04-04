package com.example.myapplication.Kotlin

//25. 상속

// 개발할 때 두번까지는 봐준다
// 두번 이상이 넘어가면 리펙토링 해라
// 리펙토링 -> 정리해라 단 정리정돈 후에도 기능이 유지되어야 한다.

// 상속
// - 부모로부터 설명서를 물려받는다!

// 클래스는 private 이 초기 기본값이다
// 변수는 아니다

fun main(array:Array<String>){

    val superCar100:SuperCar100= SuperCar100()
    println(superCar100.drive())

    val bus100:Bus100= Bus100()
    bus100.drive()


}

//부모: Car100
//자식: SuperCar100, Bus100
open class Car100(){
    open fun drive():String{
        return "달린다"
        //println("달린다")
    }
    fun stop(){

    }
}

class SuperCar100():Car100(){
    override fun drive():String { // 부모의 기능을 이용해 수정한 코드
        val run = super.drive()
        return "빨리 $run"
    }
}


class Bus100():Car100(){

}