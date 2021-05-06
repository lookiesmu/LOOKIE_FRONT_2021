package com.example.myapplication.Kotlin

import com.google.android.material.internal.BaselineLayout

fun main(array:Array<String>){


    val account:Account= Account("홍길동", "1990/3/1", 1000)
    println(account.checkBalance())
    println(account.save(2000))
    println(account.withdraw(500))
    println(account.checkBalance())

    println()
    val account2:Account2=Account2("홀길동", "1990/3/1")
    println(account2.checkBalance())


}


// 은행 계좌 만들기
// - 계좌 생성 기능(이름, 생년월일, 초기금액)
// - 잔고 확인 기능
// - 출금 기능
// - 예금 기능



class Account{

    val name:String
    val birth:String
    var balance:Int

    constructor(name:String, birth: String, balance: Int){
        this.name=name
        this.birth=birth
        if(balance>=0){ // 음수의 초기값 방지하는 역할
            this.balance=balance
        }else{
            this.balance=0
        }

    }


    // 잔고를 확인하는 기능
    fun checkBalance():Int{
        return balance
    }

    // 출금 기능
    fun withdraw(amount:Int):Boolean{
        if(balance>=amount){
            balance-=amount
            return true
        }else{
            return false
        }
    }

    // 예금 기능
    fun save(amount:Int){
        balance+=amount
    }
}

// 초기값을 1000으로 고정하는 경우 (기본값)
class Account2(val name:String, val birth:String, var balance: Int=1000){
    // 잔고를 확인하는 기능
    fun checkBalance():Int{
        return balance
    }

    // 출금 기능
    fun withdraw(amount:Int):Boolean{
        if(balance>=amount){
            balance-=amount
            return true
        }else{
            return false
        }
    }

    // 예금 기능
    fun save(amount:Int){
        balance+=amount
    }
}


class Account3(initialBalance:Int){

    val balance:Int=if(initialBalance>=0) initialBalance else 0 // 초기값 음수 방지
    fun checkBalance():Int{
        return balance
    }
}