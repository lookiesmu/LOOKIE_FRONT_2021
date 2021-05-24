# Week 06 안드로이드 Network 실습

2021.05.22 - 201911019 최현민

<br>

## 과제 설명

1. 패스트 캠퍼스 05 Essential 69강까지 수강
2. 패스트 캠퍼스 강의 내에 있는 Network 61~67강 실습 화면 캡쳐 및 강의 내용 정리 Issue 에 올리기

- 안드로이드 네트워크 관련 개념

<br>

## 안드로이드 네트워크

* 네트워크 -> 통신

* 통신 과정

  DataBase <-----> Server <------> Client(app,web,...)
       글                               					  A
       댓글                               				  B

* Local DataBase 의 한계

  * 동기화가 어렵다
  * 상호작용이 불가능 하다

* 서버와 통신하는 방법

  * 해당 url로 요청한다
  * 인증정보를 보낸다
  * JSON 형식을 사용해서 data를 보낸다
  * JavaScript Object Notation -> Javascript에서 객체를 만들 때 사용하는 표현식 이다

* JSON 형식

  * [] -> List
  * {} -> 객체
        -> "" -> 문자열
        -> ""없으면 -> 숫자

* Json Response

  ```json
  [
      {
          "id": 1,                -> 문서에 써있다
          "name": "홍길동",
          "age": 20,
          "intro": "나는 홍길동이다!"
      },
      {
          "id": 2,
          "name": "김아무개",
          "age": 10,
          "intro": "난 김아무개 입니다 :)"
      }
  ]
  ```

* Json Parsing -> Json을 코틀린이나 자바가 이해할수 있게 변형 하는 과정

* Serializable (직렬화)
  ------------------------------>
    id, name, age, intro

* 코틀린이나/ 자바가 이해할수 있는 틀

  ```kotlin
  class Person(
      var id : Int? = null
      var name : String? = null
      var age : Int? = null
      var intro : String? = null
  )
  
  Person(1,"김아무개", 20, "안녕하세요")
  ```

* Request Type과 Status Code

  | Request Type |      설명      | Status Code |
  | :----------: | :------------: | :---------: |
  |     GET      |   정보 요청    |   200 OK    |
  |     POST     | 정보 추가 요청 | 201 Created |
  |    DELETE    | 정보 삭제 요청 |             |
  |     PUT      | 정보 수정 요청 |             |

* Status Code

  * 200번대 -> 처리가 잘 됬다

* Library

  * Volly
  * Retrofit

<br>

## Result

* Networt

  ![result](https://github.com/hyunmin0317/LOOKIE_FRONT_2021/blob/master/hyunmin/week06/homework/result01.png?raw=true)

* Retrofit

  ![result](https://github.com/hyunmin0317/LOOKIE_FRONT_2021/blob/master/hyunmin/week06/homework/result02.PNG?raw=true)

  

