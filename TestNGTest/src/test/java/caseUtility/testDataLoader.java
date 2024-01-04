package caseUtility;


import commonUtility.internalLogger;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class testDataLoader {

    public static HashMap<String, List<HashMap<String, String>>> testCases = new HashMap<>();
    private static Logger logger = internalLogger.getLogger("testDataLoader");

    public static void loadServices(){

        try {
            logger.info("Starts to load test data");
            String connFile = "config/Services.xml";

            SAXReader sax = new SAXReader();
            Document doc = sax.read(connFile);

            Element rootElement = doc.getRootElement();

            //Get suites data
            List<Element> suites = rootElement.elements("TestSuite");
            for(int i=0; i<suites.size(); i++) {
                Element suite = suites.get(i);
                String suiteName = suite.attributeValue("name");

                HashMap<String, String> tmpMap = new HashMap<String, String>();

                //load cases data
                List<HashMap<String, String>> tmpList = new ArrayList<>();
                List<Element> cases = suite.elements("TestCase");
                tmpMap.clear();
                for(int t=0; t<cases.size();t++)
                {
                    Element curCase = cases.get(t);
                    List<Attribute> caseAttibutes = curCase.attributes();

                    for(int m=0;m<caseAttibutes.size();m++)
                    {
                        String name = caseAttibutes.get(m).getName();
                        String val = caseAttibutes.get(m).getValue();
                        tmpMap.put(name, val);
                    }
                    tmpList.add(new HashMap<>(tmpMap));
                    tmpMap.clear();
                }
                testCases.put(suiteName,tmpList);
            }
            logger.info("Test data loaded successfully completed");
        }
        catch (Exception e) {
            logger.error(String.format("Failed to load test data with below errors:\r\n%s", e.getMessage()));
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        testDataLoader.loadServices();
    }
}
