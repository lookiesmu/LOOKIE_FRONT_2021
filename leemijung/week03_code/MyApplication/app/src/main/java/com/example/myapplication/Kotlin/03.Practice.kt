package com.example.myapplication.Kotlin

var a=1+2+3+4+5 //연산의 결과값을 변수에 넣어 줄 수 있다
var b="1"
var c=b.toInt()
var d=b.toFloat()

var e="John"
var f="My name is $e Nice to meet you"


// Null
// -존재하지 않는다

//var abc : Int = null -> 오류
var abc1 : Int? =null //자료형 뒤에 ? 를 붙이면 null을 가질 수 있는 자료형이 된다


fun main(array: Array<String>){
    println(a)
    println(b)
    println(c)
    println(d)
    println(f)
    println(abc1)
}