# Week 1. Kotlin에 대해서 알아보자

1. Kotlin의 장점
 * 문법이 간결하며, 표현력이 좋다
 * Null safe 언어이다
 * 기존 라이브러리와 상호운용성이 좋다 (자바와 100% 호환 가능)
2. Kotlin의 기본 문법 정리
 * 변수
    * 변수란 상자이다
    * Variable (var) / Value (val)
    * var -> 내 마음대로 원하는 것을 넣을 수 있는 상자
    * val -> 한번 넣으면 바꿀 수 없는 상자
    * var/val 변수명 = 값
    * var/val 변수명 : 자료형 = 값
    * 전역변수 / 지역변수
 * 자료형
    * 정수형 -> Long > Int > Short > Byte
    * 실수형 -> Double > Float
    * 문자 -> Char
    * 문자열 -> String
    * 논리형(참True/거짓False) -> Boolean
    * 자료형 뒤에 ? 붙이면 null을 가질 수 있는 자료형이 된다 (var a : Int? = null)
 * 함수
    * Function
    * 어떤 input 을 넣어주면 어떤 output 이 나오는 것
    * fun 함수명 (변수명:타입, 변수명:타입 ..):반환형 { .. return 반환값 }
    * 함수 인지 확인시 ctrl+P
    * 반환값이 없는 함수 선언 -> 반환형 Unit
    * 가변인자를 갖는 함수 선언 -> fun 함수명 (varage 변수명:타입):반환형
    * 내부 함수
 * 분기문
    * if/else
    * 엘비스 연산자 (val number2=number ?:10) -> number가 null이라면 number2에 10이 들어간다
    * when(value)  "->"를 사용한다
    * when 구문은 조건으로 갖는 값의 모든 경우에 대응 해주는 것이 좋다
    * is Int -> int 형인가
    * in 60..70 -> 60~70 사이의 수인가
 * 배열
    * 생성하는 방법
      1. var group=arrayOf<Int>(1, 2, 3)
      2. intArrayOf
      3. charArrayOf - char -> '' / string -> ""
      4. doubleArrayOf
      5. booleanArrayOf
      6. var group=Array(size, { ; ; })
    * 값을 꺼내는 방법1 -> group.get(Index)
    * 값을 꺼내는 방법2 -> group[Index]
    * 값을 바꾸는 방법1 -> group.set(Index, value)
    * 값을 바꾸는 방법2 -> group[Index]=값
 * Collection
    * listOf / setOf / mapOf -> 변경불가
    * mutableListOf / mutableSetOf / mutableMapOf -> 변경가능
    * set은 Index가 없다
    * list
      1. add(index(옵션), value)
      2. set(index, value)
      3. removeAt(index)
    * set
      1. add(value)
      2. remove(value)
    * map
      1. put(key, value)
      2. replace(key, value)
      3. clear()
 * 반복문
    * 반복하는 방법
      1. for(item in a) { }
      2.  for((index, item) in a.withIndex()) { } - index와 같이 알고 싶을 때
      3. a.forEach { }
      4. a.forEach {item-> }
      5. a.forEachIndexed{index, item-> } - index와 같이 알고 싶을 때
      6. for(i in 0 until 9) -> 0부터 8까지
      7. for(i in 0 until 8 step(2)) -> 0부터 8까지 index 2씩 건너뛰기
      8. for(i in 8 downTo 0) -> 8부터 0까지
      9. for(i in 0..10) -> 0부터 10까지  
 * class
    * OOP -> Object Oriented Programing (객체지향 프로그래밍)
    * "객체"란? -> 이름이 있는 모든 것
    * 객체를 만드는 방법: 설명서를 만든다 (class) = 인스턴스화
    * 직접 만든 클래스는 자료형이 된다
    * 클래스 내 멤버 변수의 이름은 같을 수 없다
    * 클래스 내 함수의 이름은 같을 수 있다 (파라미터가 다르다면 구분 가능) = 오버로딩
    * constructor -> 생성자
    * init -> 클래스가 인스턴스 될 때 가장 먼저 호출
    * 체이닝 -> 자신의 클래스를 return해서 fun을 이어나가는 것
    * set(value) -> 클래스 내 변수 아래에서 실행 -> 변수에 값이 할당될 때
    * get() -> 클래스 내 변수 아래에서 실행 -> 변수가 호출될 때
    * field -> set/get에서 무한루프를 피할 수 있는 키워드
 * 접근제어자
    * private -> 외부와 내부를 단절시키는 역할
    * private fun -> 외부에 공개되지 않고 기능을 보조하는 함수로 사용
    * 초기범위 선언은 최소한으로 설정 (private, val)
 * 상속
    * 부모로부터 설명서를 물려받는다 = 외부접근
    * class는 초기 기본값이 private이다 -> "open" 키워드
    * 자식 클래스():부모클래스() { }
    * 함수 상속 : 우클릭 -> Generate
    * 자식 클래스는 부모 클래스 타입이다
    * 하지만, 부모 클래스는 자식 클래스 타입은 아니다
    * ex) supercar는 car이지만, car는 supercar가 아니다