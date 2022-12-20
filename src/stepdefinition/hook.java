package stepdefinition;

import config.environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    // extends -> inheritance
    public class hook extends environment {

        @Before
        public void before() {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }

        @After
        public void after() {
            driver.quit();
    }

}
