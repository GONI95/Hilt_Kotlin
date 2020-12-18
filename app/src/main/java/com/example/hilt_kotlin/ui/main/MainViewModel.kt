package com.example.hilt_kotlin.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hilt_kotlin.data.MyRepository

// ViewModel에서 뭔가를 생성자로 받을때 팩토리 만들어야해서 불편함 하지만
// Hilt로 의존성 주입을 받으면 편리해짐
class MainViewModel @ViewModelInject constructor(
    private val repository : MyRepository
) : ViewModel() {
    // 뷰모델에서 힐트를 사용하는 방법 : 생성자를 통해 받으면서 ViewModel에서 의존성 주입을 위한
    // 어노테이션 선언

    fun getRepositoryHash() = repository.hashCode().toString()
}