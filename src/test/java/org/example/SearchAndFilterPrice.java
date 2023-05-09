package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class SearchAndFilterPrice {
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



      /*  driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[6]/div[1]/div/div/ul/li[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/ul/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"wl-redesigned-create-list\"]/span/span/input")).submit();
*/


        //// ITEM SEARCH CLICK
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("EarPhone");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,360)");
        Thread.sleep(2000);

        // To filter the Product price and brand
        //WebElement Boat = driver.findElement(By.xpath("//*[@id=\"p_89/boAt\"]/span/a/div/label/i"));

        /*WebElement filterButton = driver.findElement(By.id("nav-filter-button"));
        filterButton.click();
*/

        WebElement brandCheckboxBoat = driver.findElement(By.xpath("//*[@id=\"p_89/boAt\"]/span/a/div/label/i"));
        brandCheckboxBoat.click();
        Thread.sleep(2000);


        WebElement brandCheckboxSamsung = driver.findElement(By.xpath("//*[@id=\"p_89/Samsung\"]/span/a/span"));
        brandCheckboxSamsung.click();
        Thread.sleep(2000);

        WebElement brandCheckboxSony = driver.findElement(By.xpath("//*[@id=\"p_89/Sony\"]/span/a/div/label/i"));
        brandCheckboxSony.click();
        Thread.sleep(2000);


       /* WebElement priceDropdown = driver.findElement(By.xpath("//div[contains(@aria-label, 'Price')]//span[@class='a-expander-prompt']"));
        priceDropdown.click();*/

        WebElement minPriceInput = driver.findElement(By.id("low-price"));
        minPriceInput.sendKeys("1000");
        Thread.sleep(2000);

        WebElement maxPriceInput = driver.findElement(By.id("high-price"));
        maxPriceInput.sendKeys("5000");
        Thread.sleep(2000);


        // min-max price GoButton
        WebElement PriceSubmitButton = driver.findElement(By.xpath("//*[@id=\"p_36/price-range\"]/span/form/span[3]/span/input"));
        PriceSubmitButton.click();
        Thread.sleep(4000);



        driver.quit();
    }

   /* @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }*/
}