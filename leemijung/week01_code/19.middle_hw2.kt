package com.example.myapplication.Kotlin

fun main(array:Array<String>){
    val calculator1=Calculator1()
    println(calculator1.plus(4, 5))
    println(calculator1.minus(4, 5))
    println(calculator1.multiply(4, 5))
    println(calculator1.divide(4, 5))

    //calculator1.plus(4, 5).plus(3, 4)
    //----------/ -> Calculator()
    //----------------------/ -> 7
    // 결론적으로 7.plus(3, 4) 는 불가능하다

    println()
    val calculator2=Calculator2()
    println(calculator2.plus(1, 2, 3, 4, 5))
    println(calculator2.minus(10, 1, 2, 3))
    println(calculator2.multiply(1, 2, 3))
    println(calculator2.divide(10, 2, 3))



    println()
    val calculator3=Calculator3(3)
    calculator3.plus(5).minus(5)
    //--------/ -> Calculator(3)
    //-------------------------/ -> Calculator(8)
    //------------------------------------------/ -> Calculator(8).minus(5)
    // 자신의 클래스를 리턴해 기능을 이어나가는 것 = 체이닝 (Chaining)
}



// 가장 쉬운 방법
class Calculator1(){
    fun plus(a:Int, b:Int):Int{
        return a+b
    }
    fun minus(a:Int, b:Int):Int{
        // 먼저 들어온 수에서 뒤에 들어온 수를 뺀다
        return a-b
    }
    fun multiply(a:Int, b:Int):Int{
        return a*b
    }
    fun divide(a:Int, b:Int):Int{
        // 먼저 들어온 수에서 뒤에 들어온 수를 나눈다
        // 리턴은 몫만 한다
        return a/b
    }
}


class Calculator2(){
    fun plus(vararg numbers:Int):Int{
        var result:Int=0
        numbers.forEach {
            result+=it
        }
        return result
    }

    fun minus(vararg numbers:Int):Int{
        var result:Int=numbers[0]
        for(i in 0 until numbers.size){
            if(i!=0){
                result-=numbers[i]
            }
        }
        return result
    }

    fun multiply(vararg numbers:Int):Int{
        var result:Int=1
        numbers.forEach {
            if(it!=0){
                result*=it
            }
        }
        return result
    }

    fun divide(vararg numbers:Int):Int{
        var result:Int=numbers[0]
        numbers.forEachIndexed{index, value->
            if(index!=0){ // 첫번째 값은 건너뛰어야 한다
                if(value!=0){
                    result=result/value
                }
            }
        }
        return result
    }
}

// 체이닝 방법
class Calculator3(val initialValue:Int){

    fun plus(number:Int):Calculator3{
        val result=this.initialValue+number
        return Calculator3((result))
    }
    fun minus(number:Int):Calculator3{
        val result=this.initialValue-number
        return Calculator3((result))
    }
    fun multiply(number:Int):Calculator3{
        val result=this.initialValue*number
        return Calculator3((result))
    }
    fun divide(number:Int):Calculator3{
        val result=this.initialValue/number
        return Calculator3((result))
    }
}

