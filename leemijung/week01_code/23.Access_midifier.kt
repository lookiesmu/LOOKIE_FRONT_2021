package com.example.myapplication.Kotlin

//23. 접근 제어자


fun main(array:Array<String>){

    val testAccess:TestAccess=TestAccess("아무개")

        // private 키워드 때문에 외부에서 더이상 사용할 수 없다
    //testAccess.test()
    //println(testAccess.name)
    //testAccess.name="아무개2" // 클래스 내 변수를 마음대로 바꿀 수 있다 -> 문제!
    //println(testAccess.name)


    val reward:Reward=Reward()
    //reward.rewardAmount=2000 // 상금을 바꿀 수 있는 문제 (마음대로 접근함)
    // -> private 으로 외부에서 접근할 수 없도록 함

}


class Reward(){
    private var rewardAmount:Int=1000
}

class TestAccess{
    private var name:String="홍길동"

    constructor(name:String){
        this.name=name
    }

    fun changeName(newName:String){
        this.name=newName
    }


    // 외부에서 사용하도록 만든 함수에 왜 private 를 붙이는가?
    // - 굳이 외부에서 사용하지 않고 기능을 보조하는 함수는 외부에 공개하지 않는다
    // private : 외부와 내부를 단절 시키는 역할
    private fun test(){
        println("테스트")
    }
}