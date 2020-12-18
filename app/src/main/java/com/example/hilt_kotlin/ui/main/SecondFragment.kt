package com.example.hilt_kotlin.ui.main

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

@AndroidEntryPoint
class SecondFragment : Fragment(R.layout.fragment_second) {

    private val activityviewModel by activityViewModels<MainViewModel>()

    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var repository : MyRepository

    @AppHash    // 10. 어느 모듈을 받을건지 선언
    @Inject
    lateinit var applicationHash : String

    @ActivityHash    // 10. 어느 모듈을 받을건지 선언
    @Inject
    lateinit var activityHash : String

    companion object{
        val TAG = SecondFragment::class.java.simpleName
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "${repository.hashCode()}")
        Log.d(TAG, "AppHash : ${applicationHash}")
        Log.d(TAG, "ActivityHash : ${activityHash}")
        Log.d(TAG, "viewModel : ${viewModel.getRepositoryHash()}")
        Log.d(TAG, "activityviewModel : ${activityviewModel.getRepositoryHash()}")

        view.findViewById<Button>(R.id.button).setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }
    }
}