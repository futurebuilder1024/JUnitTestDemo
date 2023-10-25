package com.example.junittest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class MainCoroutineRule: TestWatcher()
//    , TestCoroutineScope by TestCoroutineScope()
{
    override fun starting(description: Description) {
        super.starting(description)

    }

    override fun finished(description: Description) {
        super.finished(description)
        cleanupTestCoroutines()
//        Dispatchers.resetMain()
    }

    private fun cleanupTestCoroutines() {
        //
    }
}