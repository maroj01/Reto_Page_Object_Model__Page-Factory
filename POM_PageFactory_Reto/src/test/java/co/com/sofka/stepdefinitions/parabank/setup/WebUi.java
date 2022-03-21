package co.com.sofka.stepdefinitions.parabank.setup;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUi {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src\\test\\resources\\driver\\windows\\chrome\\chromedriver.exe";

    private static final String DEMO_QA_URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";

    protected WebDriver driver;

    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalSetUp() {
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quiteDriver() {
        driver.quit();
    }
}
