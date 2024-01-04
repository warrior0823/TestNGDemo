package testcases;

import org.testng.annotations.Test;

public class TestNGDemo {
    @Test(priority = 1)
    public void setUp(){
        System.out.println("prepare setup open browser");
    }
    @Test(priority = 2)
    public void openbrowser(){
        System.out.println("Open browser");
    }
    @Test(priority = 3)
    public void tearDown(){
        System.out.println("close browser");
    }
}
