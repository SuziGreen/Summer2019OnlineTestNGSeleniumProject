package HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.BrowserUtils;

public class BasicNavigation {
    public static void main(String[] args) {
//test case 1
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        String expectedResult= "The date of birth is not valid";
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserUtils.wait(4);
    }
}
