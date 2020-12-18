package com.example.hilt_kotlin.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppHash
// 9. 위의 두 어노테이션을 선언하여야 한다. 리텐션은 런타입도 제공한다는 의미
