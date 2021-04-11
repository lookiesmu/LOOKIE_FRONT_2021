# Week 2.

1. 부모 특성
 * android:orientation="vertical" -> 자식 수직 나열
 * android:orientation="horizontal" -> 자식 수평 나열

2. 자식 특성
 * android:layout_gravity="" -> 부모 영역내 위치 변동
 * android:layout_width="match_parent" -> 부모에 맞춘 범위
 * android:layout_width="wrap_content" -> 내용을 감싸는 범위
 * android:gravity="" -> 자식 영역내 text 위치 변동
 * 두가지 속성을 동시에 적용 -> "|"
 * android:layout_weight="" -> 크기 상관 없이 비율 조정
 * android:weightSum="" -> 전체 크기 지정
  
3. margin / padding
4. LinearLayout은 자식들이 겹칠 수 없다 -> 해결: FrameLayout, RelativeLayout
5. FrameLayout에서 먼저 선언된 자식이 아래 깔린다 (자식을 겹친다)
6. RelativeLayout 또한 자식을 겹칠 수 있다.
7. RelativeLayout 보다 FrameLayout 를 더 추천 -> RelativeLayout 는 연산이 오래 걸린다
8. ScrollView
 * 자식을 하나만 가질 수 있다 -> LinearLayout를 이용한다
 * scrollbars="none" -> bar 없애기
 * fillViewport="true" -> 기본값
9. ImageView
 * "@"-> 경로 의미
 * 같은 이미지를 해상도에 따라 여러 세트로 준비
 * scaleType="centerCrop" -> 비율 유지하면서 맞추기 (짤리는 부분 존재 가능)
10. draw 내부 이미지 직접 만들기
 * shape
    * 그라데이션
    * centerColor -> 가운데 색삭 지정
    * endColor -> 마지막 색상 지정
    * startColor -> 처음 색상 지정
    * angle -> 각도 조절
 * strock
    * 가운데가 뚫린 사각형
    * width="" -> 선 두께 지정
 * solid
    * 면
    * corners - radius -> 둥근 모서리