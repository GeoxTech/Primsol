import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class HomePage {

    @Test
    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        //Import Selenuimdriver
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //2. Input your selenium Demo Page URL (https://primso-staging.lawpavilion.com/)
        driver.get("https://primso-staging.lawpavilion.com/");


        Thread.sleep(1000);
        //3. Maximize the Chrome browser
        driver.manage().window().maximize();

        //Scroll down the website
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, document.body.scrollHeight);");

        //Scroll up the website
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, -5106);");

        //4. Click the feature tab
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[2]/a")).click();

        //5. Verify Element on the feature tab
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 1500);");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-features/div/section[6]/div/h2")).getText();
        //This will scroll the page Horizontally till the element is found
        Thread.sleep(2000);
        //js.executeScript("arguments[0].scrollIntoView();",lp);

        //6. Click on Pricing tab within the Homepage
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[3]/a")).click();

        //Confirm page pricing page url link withing the homepage
        String expectedpageUrl ="https://primso-staging.lawpavilion.com/compare";
        String actualPageurl = driver.getCurrentUrl();
        if (actualPageurl.contains(expectedpageUrl))
            //Pass
            System.out.println("Pricing page url is Correct");
        else
            //Fail
            System.out.println("Wrong pricing page Url");

        //Check for body response within Pricing page
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-compare-page/section/section[1]/table/thead/tr[1]/th[6]/div/div/div")).getText();

        Thread.sleep(3000);
        WebElement sp = driver.findElement(By.xpath("/html/body/app-root/app-layout/app-compare-page/section/section[1]/table/thead/tr[1]/th[6]/div/div/div"));
        String expectedText = "gold";
        String actualText = sp.getText();
        System.out.println(actualText);
        if (actualText.contains(expectedText))
            //Pass
            System.out.println(actualText + "Passed: Webpage contains Text");
        else
            //Fail
            System.out.println("Failed: Text not found within Webpage");


        //7. Click on Whats-new tab within the Homepage
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[4]/a")).click();
        String expectedUrl ="https://primso-staging.lawpavilion.com/whats-new";
        String actualUrl = driver.getCurrentUrl();
        if (actualPageurl.contains(expectedpageUrl))
            //Pass
            System.out.println(actualUrl + "Whats-new page url is Correct");
        else
            //Fail
            System.out.println("Whats-new pricing page Url");

        //Check for body response within Whats-New page
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, 600);");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-whats-new/section/section/div[1]/div[1]/p")).getText();
        System.out.println(actualText);


        //8. Click on Contact-Us tab within the Homepage
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[5]/a")).click();
        System.out.println(actualText);
        String pageUrl ="https://primso-staging.lawpavilion.com/contact-us";
        String expectedrightUrl = driver.getCurrentUrl();
        if (pageUrl.contains(expectedrightUrl))
            //Pass
            System.out.println("Contact-Us page url is Correct");
        else
            //Fail
            System.out.println("Contact-Us pricing page Url");


        //Check for body response within the Contact-Us Page
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 600);");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/h3")).getText();
        System.out.println(actualText);


        //9. Fill the get in touch with us form
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Stanley");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("George");

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[2]/input")).sendKeys("Enquiries on Primsol packages");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[3]/input")).sendKeys("gibbs499@gmail.com");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[4]/input")).sendKeys("08161179330");

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[5]/textarea")).sendKeys("What package can i subscribe to for my whole company ");

        //11. Click on the send button on the Get in touch with us form
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 900);");
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/button")).click();
        //Pass
        System.out.println("Messages successfully sent");

        //Quit the browser
        Thread.sleep(3000);
        driver.close();

    }

}
