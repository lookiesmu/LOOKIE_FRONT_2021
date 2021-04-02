# Week 01 Kotlin에 대해서 알아보자

2021.

`Kotlin(코틀린): Jetbrains 사에서 개발했고 2016년에 정식 버젼이 발표되었으며 2017년에 안드로이드 공식지원언어로 채택됨`

<br>

### 1. Kotlin의 장점에 대해 적어보자.

* 문법이 간결하며, 표현역이 좋다
* Null safe 언어이다
* 기존 라이브러리와 상호운용성이 좋다 (자바와 100% 호환이 된다)

<br>

### 2. Kotlin의 기본 문법을 정리해보자.

* 변수

  * 종류

    * var(Variable): 내 마음대로 원하는 것을 넣을 수 있는 상자

      `var num = 10`

    * val(Value): 한번 넣으면 바꿀 수 없는 상자 

      `val fix = 20`

  * 변수 선언하는 방법

    * var/val 변수명(상자) = 값(넣고 싶은 것)

      ```kotlin
      var num = 10
      var hello = "hello"
      var point = 3.4
      val fix = 20
      ```

  <br>

* 자료형

  * 종류

    * 정수형 -> Long > Int > Short > Byte
    * 실수형 -> Double > Float
    * 문자 -> Char
    * 문자열 -> String
    * 논리형(참True/거짓False) -> Boolean

  * 변수 선언하는 방법

    1. var/val 변수명 = 값

       ```kotlin
       var number = 10
       ```

    2. var/val 변수 : 자료형 = 값

       ```kotlin
       var number1: Int = 20
       var hello1: String = "Hello"
       var point1: Double = 3.4
       ```

  * Variable or Value??

    * 변하지 않는 값이라면 -> Value
    * 진짜 모르겠다! -> Variable

  <br>

* 함수

  * 어떤 input 을 넣어주면 어떤 output 나오는 것 (y = x + 2)

  * 함수를 선언하는 방법

    ```kotlin
    fun 함수명 (변수명: 타입, 변수명: 타입 ...) : 반환형 {
    	함수 내용
    	return 반환값
    	}
    ```

  * 함수 만들기

    1. 디폴트 값을 갖는 함수 만들기

       ```kotlin
       fun plusFive(first: Int, second: Int = 5): Int {
           val result: Int = first + second
           return result
       }
       ```

    2. 반환값이 없는 함수 만들기

       * 기본 (return 값을 Unit으로 설정)

         ```kotlin
         fun printPlus(first: Int, second: Int): Unit {
             val result: Int = first + second
             println(result)
         }
         ```

       * Unit 생략

         ```kotlin
         fun printPlus2(first: Int, second: Int) {
             val result: Int = first + second
             println(result)
         }
         ```

    3. 간단하게 함수를 선언하는 방법

       ```kotlin
       fun plusShort(first: Int, second: Int) = first + second
       ```

    4. 가변 인자를 갖는 함수 선언하기

       ```kotlin
       fun plusMany(vararg numbers: Int) {
           for (number in numbers) {
               println(number)
           }
       }
       ```

  * 함수를 호출하는 방법

    1. 기본

       ```kotlin
       val result = plus(5, 10)
       println(result)	# 15
       ```

    2. 인수를 명시적으로 전달하는 방법

       ```kotlin
       val result2 = plus(first = 20, second = 30)
       println(result2)	# 50
       val result3 = plus(second = 100, first = 10)
       println(result3)	# 110
       ```

    3. 디폴트 값을 갖는 함수 호출하기

       ```kotlin
       val result4 = plusFive(10, 20)
       println(result4)	# 30
       val result5 = plusFive(10)
       println(result5)	# 15
       
       println()
       printPlus(10, 20)	# 30
       ```

* 분기문

* 반복문