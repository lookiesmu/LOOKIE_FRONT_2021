package com.example.myapplication

class plan (val date: String, val content: String) {
    
}

class Planner(){
    val planList = ArrayList<plan>()

    fun addPlan(plan: plan){
        planList.add(plan)
    }
}