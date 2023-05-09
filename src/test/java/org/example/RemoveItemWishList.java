package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RemoveItemWishList {
    ChromeDriver driver = new ChromeDriver();

    @BeforeClass
    void setup() {

        WebDriverManager.chromedriver().setup();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D610644601173%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D14856131913356457293%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9144064%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
   /* public void getTitleFromPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8094986059");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Vinay@@123");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        */
    public void getTitleFromPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ResourceBundle r= ResourceBundle.getBundle("config");
        String username=r.getString("username");
        String password=r.getString("password");
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

        Thread.sleep(3000);

/*

        //// ITEM SEARCH CLICK
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("DEATH: AN INSIDE STORY");

        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,360)");
        Thread.sleep(2000);
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
                Thread.sleep(2000);
                driver.findElement(By.name("submit.add-to-registry.wishlist")).click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"huc-view-your-list-button\"]/span/a")).click();
                //  driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]/span/span/input")).click();
                driver.close();

            }
            driver.switchTo().window(parent);
        }
*/




        /// AFTER ADD TO WISHLIST SECTION
        WebElement AccountLists = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        Actions action1 = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action1.moveToElement(AccountLists).perform();
        Thread.sleep(4000);

        // Account And Lists
        WebElement OpenWishlist=driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[3]/span"));
        OpenWishlist.click();
        Thread.sleep(4000);

        //Nevigate to First Wish List
        WebElement ShopingList=driver.findElement(By.xpath("//*[@id=\"wl-list-entry-title-2X0JTS7IIJPCY\"]"));
        ShopingList.click();
        Thread.sleep(4000);

        //// DELETE ITEM FROM WISHLIST
       //WebElement DeleteItem = driver.findElement(By.xpath("//*[@id="delete-button-IJC8RE0NGZQCN"]/span/input"));
        WebElement DeleteItem = driver.findElement(By.name("submit.deleteItem"));
        DeleteItem.click();
        Thread.sleep(4000);



      /*  driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[6]/div[1]/div/div/ul/li[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/ul/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"wl-redesigned-create-list\"]/span/span/input")).submit();
*/
        driver.quit();
    }


}