package com.example.myapplication.Kotlin

//18. Class

// OOP -> Object Oriented Programing (객체지향 프로그래밍)
// "객체"란 뭘까?
// - 이름이 있는 모든 것

// 절차지향 프로그래밍
// -코드를 위에서 부터 아래로 실행을 하면 문제가 해결된다!

// 객체지향 프로그래밍
// - 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다!

// 객체를 만드는 방법
// - 설명서가 있어야 한다

fun main(array:Array<String>){

    // 클래스(설명서)를 이용해서 실체를 만드는 방법
    // -> 인스턴스화 -> "인스턴스"를 얻음 ( =객체 )
    Car("v8 engine", "big")

    val bigCar=Car("v8 engine", "big")
    // 직접 만든 클래스 (설명서)는 자료형이 된다
    val bigCar1:Car=Car("v8 engine", "big")

    val SuperCar:SuperCar= SuperCar("good engine", "big", "white")



    val runableCar:RunableCar= RunableCar("simple engine", "body")
    // RunableCar.ride()  ->  불가능 (설명서 일뿐이다)  변수로 받아서 기능을 사용해야 한다
    runableCar.ride()
    runableCar.dirve()
    runableCar.navi("부산")


    // 인스턴스의 멤버 변수에 접근하는 방법
    val runableCar2:RunableCar2= RunableCar2("nice engine", "long body")
    println(runableCar2.body)
    println(runableCar2.engine)

    println()
    val testClass=TestClass()
    testClass.test(1)
    testClass.test(1, 2)

    // 클래스 안의 멤버 변수는 이름이 같을 수 없다
    // 클래스 안의 함수 이름은 파라미터가 다르다면 같을 수 있다 -> 오버로딩 이라고 한다
}
// 클래스 (설명서) 만드는 방법1
class Car constructor(var engine:String, var body:String){

}

// 클래스 (설명서) 만드는 방법2 (중요)
class SuperCar{
    var engine:String
    var body:String
    var door:String

    constructor(engine:String, body:String, door:String){
        this.engine=engine
        this.body=body
        this.door=door
    }
}

// 클래스 (설명서) 만드는 방법3 -> 1번 방법의 확장
class Car1 constructor(engine:String, body:String){
    // 추가적으로 필요한 부품
    var door:String=""

    // 생성자
    constructor(engine:String, body:String, door:String):this(engine, body){
        this.door=door
    }
}

// 클래스 (설명서) 만드는 방법4 -> 2번 방법의 확장
class Car2{
    var engine:String=""
    var body:String=""
    var door:String=""

    constructor(engine:String, body:String){
        this.engine=engine
        this.body=body
    }
    constructor(engine:String, body:String, door:String){
        this.engine=engine
        this.body=body
        this.door=door
    }
}


class RunableCar(engine:String, body:String){
    fun ride(){
        println("탑승 하였습니다")
    }
    fun dirve(){
        println("달립니다")
    }
    fun navi(distination:String){
        println("$distination 으로 목적지가 설정되었습니다")
    }
}

class RunableCar2{
    var engine:String
    var body:String

    constructor(engine:String, body:String){
        this.engine=engine
        this.body=body
    }

    init{ // 클래스가 인스턴스화 될 때 무조건 가장 먼저 호출된다 (초기세팅을 할 때 유용하다)
        println("RunableCar2가 만들어졌습니다")
    }
    fun ride(){
        println("탑승 하였습니다")
    }
    fun dirve(){
        println("달립니다")
    }
    fun navi(distination:String){
        println("$distination 으로 목적지가 설정되었습니다")
    }

}


// 오버로딩
class TestClass{

    // 함수 이름이 같더라도 파라미터가 다르다면 구분할 수 있다
    fun test(a:Int){
        println("up")
    }
    fun test(a:Int, b:Int){
        println("down")
    }

}