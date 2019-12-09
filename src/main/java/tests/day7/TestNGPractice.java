package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {
    @Test
    public void test () {
        // to verify expected and actual result is the same
        //if not the same-it will throw exception and stop the program
        //also, you will see in the console what was expected
        //and what the actual was
        //click and hold command/control and click on class to open

        Assert.assertEquals("apple", "apple", "word is not correct! should be apple");
    }
        @Test
         public void verifyTitle(){
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
            String expectedTitle="Practice";
            String actualTitle =driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
            driver.quit();
    }
    //let's verify that Test Automation Practice heading is displayed
    @Test(description = "Verify that heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //if there is no element with this locator, we will get NoSuchElementException
        //and our program will stop on the findElement line
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        //to make sute that the element is visible to the user
        //because element can be present but not visible
        //we need to make sure element is visible by using assert
        //Element is not visible--will be printed if element is there but not visible
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");
        driver.quit();


    }


    }

