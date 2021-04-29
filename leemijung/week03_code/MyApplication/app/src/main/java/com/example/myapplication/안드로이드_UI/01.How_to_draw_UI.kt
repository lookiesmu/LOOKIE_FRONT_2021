package com.example.myapplication.안드로이드_UI

// 안드로이드에서 화면을 그리는 방법
// - XML 을 이용한다.
// - XML 은 뭘까
//   - DSL Language -> Domain Specific Language
//   - 안드로이드 UI를 그리기 위해 특화된 언어이다.

// 핸드폰마다 화면 크기가 다 다른데 어떻게 화면을 그려야 할까?
// - 픽셀, dpi, dp 단위  를 알아야 한다.
// - 픽셀 -> 핸드폰 화면에서 빛이 나오는 전구 -> 가장 작은 단위 (고해상도=픽셀많음)
// - dpi -> dot per inch
//   - ldpi -> 120 (1인치에 120 픽셀이 존재한다는 뜻)
//   - mdpi -> 160
//   - hdpi -> 240
//   - xdpi -> 320
//   - xxhdpi -> 480
//   - xxhdpi -> 640
// 어느 기종에서나 원하는 이미지가 나올 수 있도록 통일 시켜야 할 필요성
// - dp -> Density Independent Pixcel
//   - 픽셀 독립적인 단위
//   - dpi 대신 사용 (어느 핸드폰에서든지 동일한 화면 출력)
