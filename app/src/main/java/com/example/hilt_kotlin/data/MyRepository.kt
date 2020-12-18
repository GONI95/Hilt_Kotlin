package com.example.hilt_kotlin.data

import javax.inject.Inject
import javax.inject.Singleton

// 5. 필드 삽입을 하려면 Hilt가 해당 구성요소에 필요한 중속 항목의 인스턴스를 제공하는 방법을 알아야함
// Hilt에 결합 정보를 제공하는 방법은 생성자 삽입이다. 이로 인해 인스턴스 제공 방법을 Hilt에게 알림
// 6. hashCode가 변함없지만, 지원하는 소코프 중 Singleton 스코프를 선언하므로써 하나의 객체를
// 모든 곳에서 사용가능하게 된다.
@Singleton
class MyRepository @Inject constructor() {

}