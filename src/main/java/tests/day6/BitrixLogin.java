package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {
    //helpdesk37@cybertekschool.com
    //UserUser
    public static void main(String[] args) {
        //getDriver() method returns object of webdriver
        //we need webdriver object to send commands to the browser
        //leftside is a reference variable to reuse this object
        //object can be created and used without reference variable
        //but its gonna impossible to use that object more than once
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //enter email
        //WebElement email=driver.findElement("");
        //email.sendKeys("email@email.com")
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk37@cybertekschool.com");
        //enter password
        //* matches any element
        //it's better to specify tag name, to avoid issues finding elements
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        //to login
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        BrowserUtils.wait(2);
        driver.quit();
    }
}
