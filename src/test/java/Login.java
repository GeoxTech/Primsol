import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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


            @Test
            public void clicklogin() throws InterruptedException {

                //6. Fill Credentials and Click the Login button to sign-in
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/div[1]/input")).sendKeys("Stanley.george@lawpavilion.com");
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/div[2]/div/input")).sendKeys("Stanley@123");

                Thread.sleep(2000);
                //9. Click on the Login button to Sign-In
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/button")).click();


                //Assertion @3 Verify that Users inputs the right url and his on the right Webpage
                String expectedUrl = "https://primso-staging.lawpavilion.com/";
                String actualUrl = driver.getCurrentUrl();
                if (actualUrl.contains(expectedUrl))
                    //Pass
                    System.out.println("Correct Webpage url");
                else
                    //Fail
                    System.out.println("Wrong Webpage url");

                //7. Wait global for page to fully loading
                Thread.sleep(5000);
            }

        @Test (priority = 1)
        public void clickPlan() throws InterruptedException {

            Thread.sleep(2000);
            //10. Click on any preferred Primsol plan
            driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-options-fields/div/div[2]/label/div[2]/p[1]")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-options-fields/div/button")).click();

            //5. Verify Element and get text on the User Dashboard
            driver.findElement(By.xpath("/html/body/app-root/app-layout/mat-sidenav-container/mat-sidenav-content/app-new-layout/section/section[2]/section[1]/aside[1]/p[1]")).getText();

        }

        @AfterTest
        public void closeBrowser () {
            //Quit the browser
            driver.quit();

        }

}
