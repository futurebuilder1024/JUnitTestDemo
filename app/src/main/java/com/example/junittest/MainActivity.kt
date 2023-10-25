package com.example.junittest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import technology.cariad.cat.carkeykit.common.CarKeyKitError
import technology.cariad.cat.carkeykit.common.ManufacturerIdentifier

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var data: String? = null
    var mPwd: String? = null// 数字钥匙密码
    var mName: String? = null// keyNameHint 名称
    var mBrand: String? = null// 厂商名称
    var mDataList: MutableList<String> = mutableListOf()// 厂商名称列表容器

    var mVin: String = "VIN"// VIN 码

    private val mValues = ManufacturerIdentifier.values()// 已有的厂商列表

    private lateinit var mIdentifier: ManufacturerIdentifier// 厂商ID
    private var mTestName: String = "mock"

    fun getName(): String {
        return mTestName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate: ")
        initData()
        initView()
    }

    private fun initView() {

        findViewById<Button>(R.id.tv).setOnClickListener {
            println("data = ${data}")
        }
        findViewById<Button>(R.id.go_mock).setOnClickListener {
            startActivity(Intent(this@MainActivity, MockitoActivity::class.java))
        }

    }

    private fun initData() {

        data = "JAVA语言"
        Log.i(TAG, "initData: data = ${data}")
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