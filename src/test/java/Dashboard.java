import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dashboard {

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
            public void login() throws InterruptedException {

                //5. Fill Credentials and Click the Login button to sign-in
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/div[1]/input")).sendKeys("Stanley.george@lawpavilion.com");
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/div[2]/div/input")).sendKeys("Stanley@123");

                Thread.sleep(4000);
                //6. Click on the Login button to Sign-In
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/button")).click();


                Thread.sleep(4000);
                //7. Click on any preferred Primsol plan
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-options-fields/div/div[2]/label/div[2]/p[2]")).click();

                Thread.sleep(4000);
                //8. Click on the Login to goto dashboard
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-options-fields/div/button")).click();

                //Clear the New update Pop-up video tab
                Thread.sleep(4000);
                //driver.findElement(By.xpath("//*[@id=\"newProductTeaser\"]/div/div/div[1]/button")).click();

                //9. Verify Element and get text on the User Dashboard
                Thread.sleep(5000);
                driver.findElement(By.xpath("/html/body/app-root/app-layout/mat-sidenav-container/mat-sidenav-content/app-new-layout/section/section[2]/section[1]/aside[1]/p[1]")).getText();

                //7. Wait global for page to fully loading
                Thread.sleep(4000);
            }

        @AfterTest
        public void closeBrowser () throws InterruptedException {
            //Quit the browser
            Thread.sleep(4000);
            driver.quit();

        }


}
