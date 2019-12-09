package VyTrackProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class negativeLogin {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // setting up webdriver for the browser to use
        ChromeDriver driver = new ChromeDriver(); // will return new chromedriver object
        driver.get("http://google.com");//open google url
        BrowserUtils.wait(6); // setting time between commands
        driver.navigate().to("https://qa2.vytrack.com/user/login"); //navigating to the website
        BrowserUtils.wait(6);
        WebElement UserName = driver.findElement(By.name("_username"));  // navigating to a username functionality
        UserName.sendKeys("user190"); //truck driver info
        BrowserUtils.wait(6);
        WebElement PassWord = driver.findElement(By.name("_password")); //navigating to a password functionality
        PassWord.sendKeys("falseinfo");  //truck driver password
        BrowserUtils.wait(6);
        WebElement SignIn = driver.findElement(By.id("_submit")) ;  //  locates submit button
        SignIn.click();  // clicking LOG IN button
        BrowserUtils.wait(6);
        String expectedResult = "https://qa2.vytrack.com/";//browser is what should open
        String actualResult = driver.getCurrentUrl();//.getCurrentUrl built in method
        if(expectedResult.equals(actualResult)){
            System.out.println("Test passed");  //if the sign in was successful
        }else{
            System.out.println("Invalid user name or password"); // if the sign in  failed
        }
        BrowserUtils.wait(3);
        driver.close(); // close the browser
    }
}
