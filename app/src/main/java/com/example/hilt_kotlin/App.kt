package com.example.hilt_kotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 1. Hilt Application class : Hilt를 사용하는 앱은 어노테이션으로 주석이 지정된
// 애플리케이션 클래스를 포함해야함
@HiltAndroidApp
class App : Application() {
}