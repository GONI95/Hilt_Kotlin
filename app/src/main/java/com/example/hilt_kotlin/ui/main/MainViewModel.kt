package com.example.hilt_kotlin.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hilt_kotlin.data.MyRepository

// 14. ViewModel에서 뭔가를 생성자로 받을때 팩토리 만들어야해서 불편함 하지만
// Hilt로 의존성 주입을 받으면 편리해짐
class MainViewModel @ViewModelInject constructor(
    private val repository : MyRepository
) : ViewModel() {
    // 16. 뷰모델에서 힐트를 사용하는 방법 : 생성자를 통해 받으면서 ViewModel에서 의존성 주입을 위한
    // 어노테이션 선언

    // val repository = MyRepository()
    // tip : 의존성 주입 사용하는 이유가 크게보면 테스트의 용이성이다. 하지만 객체 안에서
    // 다른 객체를 생성하는 경우 둘 사이에 의존성이 생겨버리기 때문에 테스트에 좋지않다.
    // 따라서, 생성자로 객체를 받도록 한다.

    fun getRepositoryHash() = repository.hashCode().toString()
    // 17. 2단계에서 생성한 MyRepository 객체를 받았으니, 객체를 이용하여 hashCode를  출력하는 메소드 구현
}