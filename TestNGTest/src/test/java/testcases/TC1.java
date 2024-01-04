package testcases;

import org.testng.annotations.*;

public class TC1 {
    @BeforeClass
    void beforeClass(){
        System.out.println("Before class starts");
    }
    @AfterClass
    void afterClass(){
        System.out.println("After all classes");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("This will execute before every method");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("This will execute after every method");
    }
    @Test
    void test1(){
        System.out.println("This is test1");
    }
    @Test
    void test2(){
        System.out.println("This is test2");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("before test annotion");
    }

    @AfterTest
    void afterTest(){
        System.out.println("after test annotion");
    }

}
