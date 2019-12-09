package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicNavigation {
    public static void main(String[] args) {
        //if you have exception: cannot load a class
        //that meansthat package name doesnt matvh eith location of the class itself
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //to maximize browser
        driver.manage().window().maximize();
        driver.get("http://google.com");
        //we want to navigate, to a different page
        //within same browser
        //we will not open new browser or new tab
        //URL can be passed as an object
        //or as a string
        //we use string
        driver.navigate().to( "http://amazon.com");
        //if i want to comeback to the previous page
        driver.navigate().back();
        //if i want to know url of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //sellenium does not close browser automatically
        //for this, we use method close()
        driver.close();

    }
}
