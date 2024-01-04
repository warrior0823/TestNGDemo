package caseUtility;

import commonUtility.internalLogger;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.ITest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class testBase implements ITest {

    public static HashMap<String, String> testCases = new HashMap<>();

    @BeforeSuite
    public void TestFixtureSetUp() {
        System.out.println("load Services.xml data");
        testDataLoader.loadServices();
    }

    @DataProvider(name="input-data")
    public Object[][] provider(Method method){
//        Object[][] data = {{"baidu.com", "abc"}, {"mail.com", "12345"}};
//        return data;
        Object[][] rtnData=null;
        String methodName = method.getName();
        System.out.println(methodName);

        if(methodName.contains("Login")) {
            System.out.println("=====debug=====");
            try {
                for (Map.Entry<String, List<HashMap<String, String>>> entry: testDataLoader.testCases.entrySet())
                {
                    String suiteName = entry.getKey();
                    System.out.println(suiteName);
                    if(method.getName().toLowerCase().contains(suiteName.toLowerCase())) {
                        List<HashMap<String, String>> cases = entry.getValue();
                        rtnData = new Object[cases.size()][];
                        for(int i=0; i<cases.size();i++) {
                            HashMap<String, String> curCase = cases.get(i);
                            rtnData[i] = new Object[3];
                            rtnData[i][0] = curCase.get("url");
                            rtnData[i][1] = curCase.get("user");
                            rtnData[i][2] = curCase.get("password");
                        }
                    }
                }
            }
            catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return rtnData;
    }

    private ThreadLocal<String> testName = new ThreadLocal<>();

    @Override
    public String getTestName() {
        return testName.get();
    }
}
