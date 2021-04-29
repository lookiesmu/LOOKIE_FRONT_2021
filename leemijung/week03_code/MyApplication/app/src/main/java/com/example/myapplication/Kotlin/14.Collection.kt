package com.example.myapplication.Kotlin

//14. Collection (모음집)
//  - list, set, map



fun main(array:Array<String>){
    // Immutable Collection (val와 같이 바꿀 수 없다)


    // list -> 중복을 허용한다
    val numberList=listOf<Int>(1, 2, 3, 3)
    println(numberList)
    println(numberList.get(0))


    // set -> 중복을 허용하지 않는다
    //     -> 순서가 없다! = Index 가 없다
    val numberSet=setOf<Int>(1,2, 3, 3, 3)
    println()
    println(numberSet)
    numberSet.forEach {
        println(it)
    } // numberSet 전체 출력


    // map -> key, value 방식으로 관리한다 "key to value"
    val numberMap=mapOf<String, Int>("one" to 1, "two" to 2)
    println()
    println(numberMap.get("one"))


    // Mutable Collection (var 와 같이 변경이 가능하다)


    val mNumberList=mutableListOf<Int>(1, 2, 3)
    mNumberList.add(3, 4)
    println()
    println(mNumberList)

    val mNumberSet= mutableSetOf<Int>(1, 2, 3, 4, 4, 4)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap= mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println(mNumberMap)
}