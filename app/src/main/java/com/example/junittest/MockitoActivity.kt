package com.example.junittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MockitoActivity : AppCompatActivity() {
    private val TAG = "MockitoActivity"
    private val mName: String? = "mock"

    fun getName(): String? {
        return mName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ")
        setContentView(R.layout.activity_mockito)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")

    }
}
