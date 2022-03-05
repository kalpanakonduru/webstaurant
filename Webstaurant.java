package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class Webstaurant {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lravi\\AutomationTask\\AutomationTask\\lib\\chromedriver.exe");

        driver = new ChromeDriver();
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        driver.get("https://www.webstaurantstore.com/");
        driver.findElement(By.xpath("//input[@id='searchval']")).sendKeys("stainless work table");
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).sendKeys(Keys.ENTER);
        List<WebElement>text=driver.findElements(By.xpath("//*[contains(text(),'Table')]"));
        System.out.println("Number of Table Words:" +text.size());
        Assert.assertTrue(driver.getPageSource().contains("Table"), String.valueOf(true));
        js.executeScript("window.scrollBy(0,8000);");
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[3]/div[4]/nav[1]/ul[1]/li[8]")).click();
        driver.findElement(By.xpath("//body/div[@id='react_0HMFTRLGUGFDP']/div[1]/div[4]/div[3]/div[3]/div[59]/div[4]/form[1]/div[1]/div[1]/input[2]")).click();
        driver.findElement(By.xpath("//body/div[@id='react_0HMFTRLGUGFDP']/div[1]/div[4]/div[3]/div[3]/div[60]/div[4]/form[1]/div[1]/div[1]/input[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'View Cart')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Empty Cart')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Empty Cart')]")).click();
        driver.close();
    }
}
