package com.example.myapplication.Kotlin

//16. Iterable

fun main(array:Array<String>){
    val a= mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법1
    for(item in a){
        if(item==5){
            println("item is Five")
        }else{
            println("item is not Five")
        }
    }
    println()

    // 반복하는 방법2
    for((index, item) in a.withIndex()){
        println("index: "+index+" value: "+item)
        // 문자열 + Int = 문자열
        // 문자열 + 아무거나 = 문자열
    }

    println()
    // 반복하는 방법3
    a.forEach{
        println(it)
    }

    println()
    // 반복하는 방법4
    a.forEach{item->
        println(item)
    }

    // 반복하는 방법5
    a.forEachIndexed{index, item->
        println("index: "+index+" value: "+item)
    }

    // 반복하는 방법6
    println(a.size)
    println()
    for(i in 0 until a.size){
        // until 은 마지막 수를 포함하지 않는다
        // 0 부터 8 까지
        println(a.get(i))
    }

    // 반복하는 방법7
    println()
    for(i in 0 until a.size step(2)){
        println(a.get(i))
    }

    println()
    // 반복하는 방법8
    for (i in a.size-1 downTo (0)){
        // 8 부터 0 까지 반복
        println(a.get(i))
    }

    println()
    // 반복하는 방법9
    for (i in a.size-1 downTo (0) step(2)){
        // 8 부터 0 까지 반복
        println(a.get(i))
    }

    println()
    // 반복하는 방법10
    for(i in 0..10){
        //until 과 다르게 마지막 수까지 포함한다
        println(i)
    }

    println()
    // 반복하는 방법11
    var b:Int=0
    var c:Int=4
    while(b<c){
        b++ //while문을 정지 시키기 위한 코드
        println("b")
    }

    var d:Int=0
    var e:Int=4
    println()
    // 반복하는 방법12
    do{
        println("Hello")
        d++
    }while(d<e)




}