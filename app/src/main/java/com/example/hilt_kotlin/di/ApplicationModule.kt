package com.example.hilt_kotlin.di
import com.example.hilt_kotlin.di.qualifier.AppHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
// 8. 모듈을 만들어보는 것(MyRepository와 관련없음)
// 전체 앱에서 사용하도록 할 땐 싱글톤, 싱글톤일 땐 위의 Component를 사용
object ApplicationModule {


    // 9. Activity와 Application 모듈 두 개가 전체 앱 범위에 같은 작업을 하는 기능이기 때문에
    // 구분을 안해주면 에러남, 원하는 이름의 어노테이션을 선언하고 구분해주면 된다.
    // 예를들어 AppHash에 alt+enter로 새로운 파일을 만들어 구분해주면 됨(하나만 생성 시 구분 정할 필요는 없음)
    @AppHash
    @Provides
    fun provideHash() = hashCode().toString()
}