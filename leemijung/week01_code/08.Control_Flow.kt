package com.example.myapplication.Kotlin

//08. 제어 흐름
// - if, else



fun main(array:Array<String>){
    val a:Int=5
    val b:Int=10

    // if/else 사용하는 방법1
    if(a>b){
        println("a 가 b 보다 크다")
    }else{
        println("a 가 b 보다 작다")
    }
    // if/else 사용하는 방법2 (단독 사용)
    if(a>b){
        println("a 가 b 보다 크다")
    }
    // if/else 사용하는 방법3
    if(a>b){
        println("a 가 b 보다 크다")
    }else if(a<b){
        println("a 가 b 보다 작다")
    }else{
        println("a 와 b 가 같다")
    }

    // 값을 리턴하는 if 사용방법
    val max=if(a>b){
        a
    }else{
        b
    }
    val max1=if(a>b) a else b
    println()
    println(max)
    println(max1)
}