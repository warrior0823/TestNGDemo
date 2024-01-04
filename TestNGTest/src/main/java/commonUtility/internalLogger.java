package commonUtility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class internalLogger {
    public static Logger getLogger(@SuppressWarnings ( "rawtypes" ) Class aClass)
    {
        Logger logger = Logger.getLogger(aClass);
        PropertyConfigurator.configure("log4j.properties");

        return logger;
    }

    public static Logger getLogger(String name)
    {
        Logger logger = Logger.getLogger(name);
        PropertyConfigurator.configure("log4j.properties");

        return logger;
    }
}
