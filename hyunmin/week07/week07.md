# Week 07 OkHttp()에 대하여 알아보자

2021.05.27 - 201911019 최현민

<br>

## 과제 설명

1. OkHttp와 Retrofit 차이 조사하기
2. OKHttp에 대한 조사하고 공부한 내용 올리기

- 이번 주는 쉬어가는 개념 정리 과제!(과제 관련 패스트 캠퍼스 강의 들을 필요없습니다.)

<br>

## OkHttp와 Retrofit 차이

* OkHttp
  * 서버와 HTTP, HTTP/2 프로토콜 통신을 위한 클라이언트 라이브러리
  * REST API, HTTP 통신을 간편하게 구현할 수 있도록 다양한 기능을 제공해주는 라이브러리
  * Retrofit이라는 라이브러리의 베이스
* Retrofit
  * type-safe한 HTTP 클라이언트 라이브러리
  * RESTFul 통신을 쉽게 할 수 있음
  * 앱을 만들다 보면 서버에 있는 정보를 이용해야함
    * http 통신 => 인터넷에 있는 정보를 가져오는 작업
    * 원하는 데이터를 입력하고(변수 넘겨줌) 가져오는 작업
  * 변수넘기는 방법 2가지 get, post
    * get : 변수가 눈에 보임
    * post : 변수가 눈에 안보임, 보안상
  * Anotation 을 사용함
  * Java Interface에 대한 개념이 있어야 수월하게 진행 할 수 있다. Interface로 통신하는 부분을 만듬
  * 인터페이스 1개와 클래스 1개 필요함
  * 통신할때 필요한 interface를 생성함
  * interface안에는 annotation을 사용하여 통신할 httpMethod를 적어줌

<br>

## OkHttp

* 안드로이드에서 HTTP로 통신하기 위한 과정을 단순화

  * 안드로이드에서 HTTP로 통신하는 과정
    1. HttpURLConnection 연결
    2. Buffer를 통한 입출력
    3. 예외 처리
* 스레드를 써가면서 네트워크를 구축하지 않아도 됨
* 유명 라이브러리 Volley, Retrofit, OkHttp3 등이 있음
* 네트워크 구축시 필요한 쿠키, 캐시등을 지원해주고 예외 상황에 대한 풍부한 리소스를 제공함

