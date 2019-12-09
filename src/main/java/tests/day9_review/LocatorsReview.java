package tests.day9_review;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Verify checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        //[type ='checkbox'] since there are 2 elements with a same locator
        //and I need only first one, i can use in css,:nth-of-type(index)7th, 8th etc..
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type ='checkbox']:nth-of-type(1)"));
        //how to verify a checkbox is checked or not
        Assert.assertFalse(checkbox1.isSelected(),"checkbox 1 was selected");//assert check box is checked
        //[index] - to specify index of the element, if there are multiple elements with this xpath
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(),"checkbox 2 was not selected");
        //again, css selector is preferable, because of speed.
        //assertion is like an if statement

    }
    

    @AfterMethod
    public void teardown(){
        System.out.println();
        driver.quit();
    }
}
