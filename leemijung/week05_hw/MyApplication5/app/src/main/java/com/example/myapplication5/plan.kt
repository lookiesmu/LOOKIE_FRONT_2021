package com.example.myapplication5

//클래스 선언
class Plan(val date:String, val contents:String){


}

//plan 리스트 생성 -> adapter에 전달해야 함(list)
class Planner(){
    val planlist=ArrayList<Plan>()

    fun add(plan:Plan){
        planlist.add(plan)
    }
}