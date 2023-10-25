package com.example.junittest.mockk

class ServiceImpl:Service {
    override fun doSomething(any: Any): String {
        println("ServiceImpl::class.simpleName = ${ServiceImpl::class.simpleName} = "+any.toString())
        return any.toString()
    }

    override fun doSomethingReal(any: Any) {
        println("Real ServiceImpl::class.simpleName = ${ServiceImpl::class.simpleName} = "+any.toString())
    }
}