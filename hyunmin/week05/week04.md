# Week 05 안드로이드 RecyclerView 실습

2021.05.15 - 201911019 최현민

<br>

## 과제 설명

1. 패스트 캠퍼스 05 Essential 50강까지 수강(Tablayout, Pager까지)

2. 나만의 여름방학 계획표 작성하기

   - 기능 1. Recycler View 로 계획표 날짜, 내용이 보이도록 함

   - 기능 2. 새로운 계획을 추가할 수 있도록 함

   - class file 3개 (main, plan, planAdapter), XML file 3개 (main, planview, dialogview)

     ```
       class | main: (-)
               plan: 계획의 정보 (날짜, 내용)을 담을 클래스
               planAdapter: main의 RecyclerView에 장착할 CustomAdapter
       XML   | main: Button 1개,RecyclerView 1개
               planview: TextView 2개 (날짜, 내용)
               dialogview: EditText 3개 (날짜, 내용)
     ```

   - 설명 :

     ```
       main화면의 Button 클릭 시 Dialog 보여진다.
       Dialog내에서 2개의 값 입력후 추가 버튼 클릭 시 main화면에 해당 계획정보가 추가되고 Dialog가 종료된다.
       취소 버튼 클릭 시 아무런 동작없이 Dialog가 종료된다.
     ```

   - 조건 :

     ```
       계획 정보는 항상 리스트의 가장 위에 추가된다. Dialog의 editText값들이 채워지지 않은 경우는 고려하지 않는다.(예외처리 필요없음)
     ```

- Dialog가 어려운 경우 https://juyeop.tistory.com/7 사이트 참고하여 기능을 구현해도 됩니다.

<br>

## Result

![result]

