package com.example.hilt_kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilt_kotlin.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
// 6. EntryPoint를 프래그먼트를 띄우는 액티비티에도 선언해주어야함
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}