package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

public class AddToWishList {
    ChromeDriver driver = new ChromeDriver();
    @BeforeClass
    void setup()
    {

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D610644601173%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D14856131913356457293%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9144064%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

    }
    @Test(priority = 1)
    public void getTitleFromPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ResourceBundle r= ResourceBundle.getBundle("config");
        String username=r.getString("username");
        String password=r.getString("password");
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

        Thread.sleep(15000);
        ////////HOVER////////
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();



        //// ITEM SEARCH CLICK
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("DEATH: AN INSIDE STORY");

        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,360)");
        Thread.sleep(8000);
        /// ITEM CLICK
        // commented out below line because due ads unable To click the desired link
//        driver.findElement(By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] h2[class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'] span:nth-child(4)")).click();
        driver.findElement(By.xpath("//span[text() = \"DEATH: AN INSIDE STORY\"]")).click();
        Thread.sleep(8000);
        String parent=driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window = I1.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle());
                js.executeScript("window.scrollBy(0,360)");
                Thread.sleep(6000);
                driver.findElement(By.name("submit.add-to-registry.wishlist")).click();

                Thread.sleep(6000);
                driver.findElement(By.xpath("//*[@id=\"huc-view-your-list-button\"]/span/a")).click();
                //  driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]/span/span/input")).click();
                driver.close();

            }
            driver.switchTo().window(parent);
        }

        driver.quit();

    }
}
