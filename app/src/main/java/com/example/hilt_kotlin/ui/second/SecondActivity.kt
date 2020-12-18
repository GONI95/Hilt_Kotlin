package com.example.hilt_kotlin.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hilt_kotlin.R
import com.example.hilt_kotlin.data.MyRepository
import com.example.hilt_kotlin.di.qualifier.ActivityHash
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var repository : MyRepository

    // kotlin에는 static 메소드가 없음, 패키지 수준에서 최상위 함수와 객체 선언을 사용 가능
    // 객체 선언은 최상위 함수가 접근할 수 없는 클래스 내에 private 멤버 변수에 접근해야 할 때 사용할 수 있다.
    // 상수로 사용할 데이터를 동반객체를 이용해 사용
    companion object{
        val TAG = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "${repository.hashCode()}")
    }
}