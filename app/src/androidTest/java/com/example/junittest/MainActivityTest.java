package com.example.junittest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Intent;
import android.util.Log;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private static final String TAG = "MainActivityTest";

    private MainActivity mainActivity;

    @Before
    public void setUp() {

    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule
            = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public ActivityTestRule<MockitoActivity> mockitoActivityRule
            = new ActivityTestRule<>(MockitoActivity.class);

    /** 修改private 变量*/
    @Test
    public void getTestName() {
        mainActivity = mainActivityRule.getActivity();
        try {
//            Whitebox.setInternalState(mainActivity, "mTestName", "java");
//            MemberModifier.field(MainActivity.class,"mTestName").set(mainActivity,"java");
//            Assert.assertEquals("mock",mainActivity.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 调用私有构造方法
     */
    @Test
    public void testPrivateConstructMethod() throws Exception {
//        MessageDemo messageDemo = Whitebox.invokeConstructor(MessageDemo.class, "MessageDemo");
//        messageDemo.printMessage("private_province");
//        Assert.assertEquals("private_province", messageDemo.printMessage("private_province"));
    }
    @Test
    public void test() {

        ActivityScenario<MainActivity> mScenario = ActivityScenario.launch(MainActivity.class,null);

        // 模拟点击跳转事件
        onView(withId(R.id.tv)).perform(click());
        onView(withId(R.id.go_mock)).perform(click());

    }

    /** Activity 跳转*/
    @Test
    public void goMockitoActivity() {
        MainActivity mainActivity = mainActivityRule.getActivity();
        mockitoActivityRule.launchActivity(new Intent(mainActivity, MockitoActivity.class));
    }
    @Test
    public void onCreate() {
        Log.i(TAG, "onCreate: ");

    }

    @Test
    public void onStart() {
        Log.i(TAG, "onStart: ");
    }

    @Test
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
    }

}
