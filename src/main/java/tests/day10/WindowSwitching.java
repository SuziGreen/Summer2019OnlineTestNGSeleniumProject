package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test
    public void test1() {
        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong!");

    }
     @Test(description = "Verify that user is able to see new window")
             public void test2(){
         driver.findElement(By.linkText("New tab")).click();
         //record id of original window, that we opened initially
         String oldWindow=driver.getWindowHandle();
         //after 3 seconds, another website will be opened,in the second window
         //selenium doesn't switch automatically to the new window
         BrowserUtils.wait(5);
         //in the selenium every window has an id. That id calls window handle
         //to read window handle we use a method getWindowHandle()
         //after new window was opened, we can get list of all window id's/window handles
         //list- its a data structure
         //set is also a data structure, like list, but it doesnt allow duplicates
         //also, you cannot easily access anything from there
         //there is no .get() method
         //we need to loop throught the set to read the data
         //set can only store unique characters
         Set<String> windowHandles  =driver.getWindowHandles();
         //loop throught he collection of window handles
         for(String windowHandle: windowHandles){
             //if its not an old window
             if(!windowHandle.equals(oldWindow)){
                 //switch to that window
                 driver.switchTo().window(windowHandle);
             }
         }
         //verify that title of new window is Fresh Tab
         System.out.println(driver.getTitle());
         Assert.assertEquals(driver.getTitle(),"Fresh tab", "Title is wrong!");
         //comeback to original page
         //we can build a function, that will jump ini between windows
         //

         String pageTitle = "Practice";//title of page we want

         for (String windowHandle : windowHandles){
             //keep jumping from window to window
             driver.switchTo().window(windowHandle);
             //once we have found a correct page title
             if (driver.getTitle().equals(pageTitle)){
                 //just exit
                 //
                 break;

             }
         }

        }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
