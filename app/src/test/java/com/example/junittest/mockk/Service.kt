package com.example.junittest.mockk

interface Service {
    fun doSomething(any: Any):String
    fun doSomethingReal(any: Any)
}