package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterTest {

    @BeforeClass
    @Parameters({"browser", "url"})
    void test01(String browser, String url){
        if(browser.equalsIgnoreCase("Chrome")){
            System.out.println("用谷歌浏览器进行操作");
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.out.println("用火狐浏览器操作");
        }
    }
    @Test(groups = {"sanity"})
    void test02(){
        System.out.println("进行网页操作");
    }
    @AfterClass
    void test03(){
        System.out.println("关闭浏览器");
    }
}
