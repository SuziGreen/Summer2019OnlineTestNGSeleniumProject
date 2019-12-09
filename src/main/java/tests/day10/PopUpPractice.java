package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {

    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Click on Pop Up Message")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);
        // to deal with pop up we can create an object of Alert
        //switches to the currently active modal dialog
        Alert alert = driver.switchTo().alert();
        alert.accept();
        BrowserUtils.wait(2);
    }

    @Test(description = "Click on cancel in pop up message")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        //print text of pop up message
        System.out.println(alert.getText());
        //to click cancel
        alert.dismiss();
        BrowserUtils.wait(2);
        //to print text of result
        System.out.println(driver.findElement(By.id("result")).getText());
    }

    @Test(description = "Click on button 3 and enter some text then click OK")
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Java is Fun!");

        driver.switchTo().alert().accept();
        //to print text of result
        //should be java is fun
        System.out.println(driver.findElement(By.id("result")).getText());
        BrowserUtils.wait(2);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}