package com.example.myapplication.Kotlin

//12. 배열

// 배열이 필요한 이유
// - 그룹(모음집)이 필요할 때

fun main(array:Array<String>){
    // 배열을 생성하는 방버1
    var group1=arrayOf<Int>(1, 2, 3, 4, 5)

    println(group1 is Array)

    // 배열을 생성하는 방법2
    val group2=arrayOf(1, 2, 3.5, "Hello")

    // Index 란 -> 순서(번째)
    // - "0"부터 시작

    // 배열의 값을 꺼내는 방법1
    val test1= group1.get(0)
    println(test1)

    // 배열의 값을 꺼내는 방법2
    val test2=group1[0]
    println(test2)

    // 배열의 값을 바꾸는 방법1
    group1.set(0, 100)
    println(group1[0])

    // 배열의 값을 바꾸는 방법2
    group1[0]=200
    println(group1[0])
}