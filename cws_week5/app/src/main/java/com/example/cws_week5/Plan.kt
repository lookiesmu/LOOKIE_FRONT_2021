package com.example.cws_week5

class plan(val date: String, val content: String) {

}

class planlist() {
    val planlist = ArrayList<plan>()

    fun addPlan(plan: plan){
        planlist.add(plan)
    }
}