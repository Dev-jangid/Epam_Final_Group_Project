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

public class DeleteWishList {
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
      /*  WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
///////////////////////////////////////////////////////////////////////
        /// CREATING WISHLIST
        WebElement CreateAWishList= driver.findElement(By.xpath("//span[normalize-space()='Create a Wish List']"));
        CreateAWishList.click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"create-list-form\"]/div[3]"));
        Thread.sleep(2000);
        // driver.findElement(By.xpath("//span[contains(@class,'button')][text() = \"Create List\"]")).click();


       *//* WebElement element = driver.findElement(By.xpath("//span[contains(@class,'button')][text() = \\\"Create List\\\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
*//*
        Thread.sleep(8000);

        driver.findElement(By.xpath("//*[@id=\"list-name\"]")).clear();
        Thread.sleep(8000);

        driver.findElement(By.xpath("//*[@id=\"list-name\"]")).sendKeys("My new WishList 1");
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"wl-redesigned-create-list\"]/span/span/input")).click();
        Thread.sleep(8000);*/



        WebElement AccountLists = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        Actions action1 = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action1.moveToElement(AccountLists).perform();
        Thread.sleep(8000);

        WebElement OpenWishlist=driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[3]/span"));
        OpenWishlist.click();
        Thread.sleep(8000);


        ///  Delete WishList
        //Choose to delete the list
        WebElement ListName = driver.findElement(By.xpath("//*[@id=\"wl-list-entry-title-2V18RZCKRUJ2H\"]"));
        ListName.click();
        Thread.sleep(8000);

        //Delete
        WebElement MoreDotes = driver.findElement(By.xpath("//*[@id=\"overflow-menu-popover-trigger\"]/div[1]/span"));
        Thread.sleep(8000);

       // WebElement EditList = driver.findElement(By.id("editYourList"));
        WebElement EditList = driver.findElement(By.xpath("//*[@id=\"overflow-menu-popover-trigger\"]/div[1]/span"));
        EditList.click();

        // Find the wishlist's delete button and click on it
        WebElement DeleteList= driver.findElement(By.xpath("//*[@id=\"wl-list-entry-title-2V18RZCKRUJ2H\"]"));
                DeleteList.click();

        /*//Creating object of an Actions class
        Actions DeleteAction = new Actions(driver);

        //Performing the mouse hover action on the target element.
        DeleteAction.moveToElement(deleteButton).perform();*/
        Thread.sleep(6000);


        // Confirm the deletion by clicking on the "Delete" button in the confirmation dialog
        WebElement confirmDeleteButton = driver.findElement(By.xpath("//*[@id=\"list-delete-confirm\"]/span/input"));
      //  WebElement confirmDeleteButton = driver.findElement(By.id("list-delete-confirm"));
        confirmDeleteButton.click();


        driver.quit();

    }
}
