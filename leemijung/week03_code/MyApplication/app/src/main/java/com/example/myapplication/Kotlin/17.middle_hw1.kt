package com.example.myapplication.Kotlin



fun main(array:Array<String>){

    // 1번
    var list1=mutableListOf<Int>()
    var list2= mutableListOf<String>()

    for(i in 0 until 10){
        list1.add(i, i)
        if(list1.get(i)%2==0){
            list2.add(i, "True")
        }else{
            list2.add(i, "False")
        }
    }
    println(list1)
    println(list2)


    println()
    // 2번
    var grades:Int=82
    when(grades){
        in 80..90->println("A")
        in 70..79->println("B")
        in 60..69->println("C")
        else->println("F")
    }


    println()
    // 3번
    var num:Int=77

    var ten:Int=num/10
    var one:Int=num-ten*10
    println(ten+one)









}





