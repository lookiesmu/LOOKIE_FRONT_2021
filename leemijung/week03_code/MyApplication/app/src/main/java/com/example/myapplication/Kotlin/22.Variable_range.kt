package com.example.myapplication.Kotlin

// 변수의 접근 범위
// 1. 전역 변수
// 2. 지역 변수 -> 종류가 여러개


var number100:Int=10  // - 전역변수

fun main(array:Array<String>){
    println(number100)

    val test:Test=Test("홍길동")
    test.testFun()
    test.name="이미정" // 클래스 내 변수에 접급하는 방법
    println(test.name)
    println(number100)

}



class Test(var name:String){
    fun testFun(){
        var birth:String="2000/4/2" // - 함수 내 지역변수
        name="홍길동" // - 클래스 내 지역변수
        number100=100
    }


}