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

                Thread.sleep(4000);
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
                Thread.sleep(4000);
            }

            @Test (priority = 1)
            public void clickPlan() throws InterruptedException {

                Thread.sleep(5000);
                //10. Click on any preferred Primsol plan
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-options-fields/div/div[2]/label/div[2]/p[2]")).click();

                Thread.sleep(5000);
                // Click on the Login to goto dashboard
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-options-fields/div/button")).click();

                //5. Verify Element and get text on the User Dashboard
                Thread.sleep(5000);
                driver.findElement(By.xpath("/html/body/app-root/app-layout/mat-sidenav-container/mat-sidenav/div/app-user-sidebar/div/ul[1]/a[1]/div/span[3]")).click();

                //Assertions
                Thread.sleep(4000);
                String expectedUrl = "https://primso-staging.lawpavilion.com/dashboard";
                String actualUrl = driver.getCurrentUrl();
                if (expectedUrl.contains(actualUrl))
                    //Pass
                    System.out.println("Dashboard active Passed");
                else
                    //Fail
                    System.out.println("Dashboard active Failed");

            }

            @Test (priority = 2)
            public void logout() throws InterruptedException {
                //Clear the New update Pop-up tab
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"newProductTeaser\"]/div/div/div[1]/button")).click();

                //11. Click on the logout menu
                Thread.sleep(4000);
                driver.findElement(By.xpath("//*[@id=\"dropdownMenu2\"]/span[1]")).click();

                //11. Click on the Logout button
                Thread.sleep(4000);
                driver.findElement(By.xpath("/html/body/app-root/app-layout/mat-sidenav-container/mat-sidenav-content/app-new-layout/section/section[1]/article[2]/div[1]/div/div[2]/div/div[4]/div/div")).click();

                //Pass
                System.out.println("User logged out successfully");
            }

            @Test (priority = 3)
            public void InvalidsignIn() throws InterruptedException {
                // Refresh the Url
                Thread.sleep(4000);
                driver.get("https://primso-staging.lawpavilion.com/");
                driver.get(driver.getCurrentUrl());

                //6. Fill Credentials and Click the Login button to sign-in
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/div[1]/input")).sendKeys("Stanley.george@lawpavilion.com");
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/div[2]/div/input")).sendKeys("Stanley@");


                Thread.sleep(4000);
                //9. Click on the Login button to Sign-In
                driver.findElement(By.xpath("/html/body/app-root/app-layout/app-landing-page/main/section[1]/div/div[1]/div[2]/app-login-fields/form/button")).click();

                Thread.sleep(5000);
                //Assert error messages for invalid credentials
                //driver.findElement(By.xpath("//*[@id=\"cdk-overlay-2\"]/snack-bar-container/simple-snack-bar")).getText();

                Thread.sleep(5000);
                // Close invalid error Pop-up
                driver.findElement(By.xpath("//*[@id=\"cdk-overlay-3\"]/snack-bar-container/simple-snack-bar/div/button"));


            }

        @AfterTest
        public void closeBrowser () {
            //Quit the browser
            driver.quit();

        }

}
