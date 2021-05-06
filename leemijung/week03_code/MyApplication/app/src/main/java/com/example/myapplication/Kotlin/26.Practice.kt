package com.example.myapplication.Kotlin

// 과제
// Night, Monster (부모)  -> Charactor로 줄어보자!
// SuperNight, SuperMonster (자식)


fun main(array:Array<String>){


    val monster:SuperMonster= SuperMonster(100, 10)
    val night:SuperNight= SuperNight(130, 8)

    monster.attack(night)
    monster.bite(night)
}



// 상속이 만들어낸 특징 (중요)
// - 자식 클래스는 부모 클래스의 타입이다
// - 부모 클래스는 자식 클래스의 타입은 아니다!
// ex) supercar는 car이지만, car가 supercar는 아니다!


open class Charactor(var hp:Int, val power:Int){
    fun attack(charactor:Charactor, power:Int=this.power){ // power값이 명시되지 않으면 각 클래스의 기본값으로 만들어줘야 한다
        charactor.defense(power)
    } // power 중첩되는 부분
    open fun defense(damage:Int){
        hp-=damage
        if(hp>0)println("${javaClass.simpleName}의 남은 체력 $hp")
        else println("사망 했습니다")
    }
}

// 자식 클래스가 인스턴스화 되기 위해서는 부모 클래스가 선행되어 인스턴스화 되어야 한다
// 부모로부터 넘어온 것을 val/var 적으면 안된다
// 자식에서 새로 만드는 것은 val/var 적어야 한다  (ex, val item:String)
class SuperMonster(hp:Int, power:Int):Charactor(hp, power){
    fun bite(charactor: Charactor){ // 공격력 +2 // 공격력이 2만큼 증가한 상태로 공격
        super.attack(charactor, power+2)
    }
}
class SuperNight(hp:Int, power:Int):Charactor(hp, power){
    val defensePower=2
    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}