import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Login {

        //Import the Selenium WebDriver
        private WebDriver driver;

        @BeforeTest
        public void start() throws InterruptedException {
            //Locate chromedriver
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

            //1. Open Chrome browser
            //Import Selenuim Web-driver
            driver = new ChromeDriver();

            //2. Input your selenium Demo Page URL (https://primso-staging.lawpavilion.com/)
            driver.get("https://primso-staging.lawpavilion.com/");
            //Assertion @1
            if (driver.getCurrentUrl().contains("https://primso-staging.lawpavilion.com/"))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");

            Thread.sleep(1000);
            //3. Maximize the Chrome browser
            driver.manage().window().maximize();

            //4 Get the Page title for Primsol Page title
            System.out.println(driver.getTitle());
        }

        @AfterTest
        public void closeBrowser () {
            //Quit the browser
            driver.quit();

        }

}
