package testcases;

import caseUtility.testBase;
import org.testng.annotations.Test;


public class LoginTest extends testBase {

    @Test(dataProvider = "input-data")
    public void GUILoginCheck(String url, String user, String pwd){
        System.out.println("URL: " + url + "  userName: " + user + "  Password: " + pwd);

    }
}
