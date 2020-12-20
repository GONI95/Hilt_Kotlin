package com.example.hilt_kotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hilt_kotlin.R
import com.example.hilt_kotlin.data.MyRepository
import com.example.hilt_kotlin.di.qualifier.ActivityHash
import com.example.hilt_kotlin.di.qualifier.AppHash
import com.example.hilt_kotlin.ui.second.SecondActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// https://developer.android.com/training/dependency-injection/hilt-android

@AndroidEntryPoint
// 4. Application 클래스에 Hilt를 설정하고 애플리케이션 수준의 구성요소를 사용할 수 있게되면
// Hilt는 @AndroidEntryPoint 주석이 있는 다른 Android 클래스에 종속 항목을 제공할 수 있다.
class MainFragment : Fragment(R.layout.fragment_main) {

    /**
     * 생성되는 객체가 같은지 확인을 위해 Second 프래그먼트에도 객체, 로그 등을 생성해줘야함
     */

    // 5. 종속성 주입을 받고자하는 대상에 @Inject를 표시해주어야함
    @Inject
    lateinit var repository : MyRepository
    // MyRepository 객체를 생성했지만 다른 Activity, Fragment에 있는 객체들과 다른 객체임

    // 13. 어느 모듈을 받을건지 선언
    @AppHash
    @Inject
    lateinit var applicationHash : String
    // 생성한 모듈

    // 13-1. 어느 모듈을 받을건지 선언
    @ActivityHash
    @Inject
    lateinit var activityHash : String
    // 생성한 모듈

    private val viewModel by viewModels<MainViewModel>()
    // 15. 뷰모델 객체 생성(뷰모델에 힐트 사용을 위해서)
    // main과 second 프래그먼트에 생성된 객체는 다르지만 주입되는 객체는 같음

    private val activityviewModel by activityViewModels<MainViewModel>()
    // 18. MainActivity의 lifeCycle이 관리하는 뷰모델
    // 아래의 뷰모델과 타입은 같지만 또 다른 뷰모델 객체임

    companion object{
        val TAG = MainFragment::class.java.simpleName
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "${repository.hashCode()}")
        Log.d(TAG, "AppHash : ${applicationHash}")
        Log.d(TAG, "ActivityHash : ${activityHash}")
        Log.d(TAG, "viewModel : ${viewModel.getRepositoryHash()}")
        Log.d(TAG, "activityviewModel : ${activityviewModel.getRepositoryHash()}")
        // hashCode : 객체가 생성될 때 마다 각각 고유한 hashCode를 가짐
        // equals() : 두 객체의 내용이 같은지 확인 Method (== : 주소값을 확인)
        // hashCode() : 두 객체가 같은 객체인지 확인하는 Method

        view.findViewById<Button>(R.id.button_activity).setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }



        view.findViewById<Button>(R.id.button_fragment).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }
    }

}