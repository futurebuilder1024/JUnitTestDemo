package com.example.junittest.mockk

import io.mockk.FunctionAnswer
import io.mockk.ManyAnswersAnswer
import io.mockk.MockKAdditionalAnswerScope
import io.mockk.ThrowingAnswer
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.spyk
import org.junit.Test
import java.lang.RuntimeException

class MockkTest {

    @Test
    fun testService() {
        val serviceImpl: Service = mockk<ServiceImpl>()

        every {
            serviceImpl.doSomething(any())
        }returns
        serviceImpl.doSomething(any = Any())
//        serviceImpl.doSomethingReal(any = Any()) //该方法未通过every进行mock，会报错
    }

    @Test
    fun testObject() {
        val serviceImpl = ServiceImpl()

        mockkObject(serviceImpl)
        every {
            serviceImpl.doSomething(any())
        }returns
        //调用被mock方法
        serviceImpl.doSomething(any = Any())
        //调用真实方法
        serviceImpl.doSomethingReal(any = Any())
    }

    @Test
    fun testSpyk() {
        //返回ServiceImpl的一个spyk对象
        val serviceImpl = spyk<ServiceImpl>()
//        every {
//            serviceImpl.doSomething(any())
//        }returns String()
        serviceImpl.doSomething(any = Any())//调用mock方法
        serviceImpl.doSomethingReal(any = Any())//调用真实方法


    }

    @Test
    fun testSpyk2() {
        val impl = ServiceImpl()
        //返回serviceImplA对象被spyk后的对象，原对象不会改变
        val spyk = spyk(impl)
        //mock
//        every {
//            spyk.doSomething(any())
//        }returns String()
        spyk.doSomething("spy")
        spyk.doSomethingReal("spy")
    }
    @Test
    fun testAnswers() {
        val input = "222"
        val spyk = spyk<ServiceImpl>()
        // mock
        every {
            spyk.doSomething(any())
        }answers {
            println(" 定制mock行为")
            //拿到真实函数信息
            val originalCall = invocation.originalCall
            //调用真实行为并拿到响应结果
            val originalResult = callOriginal()
            val invoke = originalCall.invoke()
            //返回一个固定结果
            "mock result"
        }
        //调用会执行answers里代码
        spyk.doSomething(input)

        every {
            spyk.doSomething(any())
        } propertyType(String::class) answers{
            //拿到第一个输入参数
            val firstArg = firstArg<String>()
            println("输入 firstArg = ${firstArg}")
            println("这里是mock后的行为")
            //定制方法返回
            "mock响应$firstArg"

        }
        spyk.doSomething(input)// out : 输入 firstArg = 222

    }

    @Test
    fun `testAnd-then`() {
        val input = "222"
        val spyk = spyk<ServiceImpl>()
        every {
            spyk.doSomething(any())
        } propertyType (String::class) answers {
            val firstArg = firstArg<String>()//拿到第一个输入参数
            println("第一次执行，输入 firstArg = ${firstArg}")
            //定制方法返回
            "第一次执行mock响应$firstArg"
        } andThenAnswer {
            //拿到输入参数
            val firstArg = firstArg<String>()
            println("第二次执行，输入：$firstArg")
            //定制方法返回
            "第二次执行mock响应$firstArg"
        }
        spyk.doSomething(input)//out:第一次执行，输入 firstArg = 222
        spyk.doSomething(input + input)//out: 第二次执行，输入：222222

    }

    @Test
    fun testAndThenAnswer() {
        val spyk = spyk<ServiceImpl>()
        //定义函数mock行为
        val functionAnswer = FunctionAnswer {
            println("functionAnswer")
            ""
        }
        //定义异常mock行为，返回一个运行时异常
        val throwingAnswer = ThrowingAnswer(RuntimeException())
        //定义多个行为处理集合，按添加顺序触发
        val manyAnswersAnswer = ManyAnswersAnswer(listOf(functionAnswer, throwingAnswer))
        // mock
        val returns = every {
            spyk.doSomething(any())
        }.returns(String.toString())

//        returns.andThenAnswer (functionAnswer) andThenAnswer (throwingAnswer
//                //构造了两个ConstantAnswer组成一个ManyAnswersAnswer对象
//                //listOf里输入的每个元素会最终赋值到ConstantAnswer的answer方法调用上
//                //如果这里传入的是字符串，则代表这个answer就仅仅是返回这个字符串
//                //这里的泛型对应里spyk.doSomething2()的返回参数类型
//                ) andThenMany (listOf("functionAnswer", "throwingAnswer"))



    }
}