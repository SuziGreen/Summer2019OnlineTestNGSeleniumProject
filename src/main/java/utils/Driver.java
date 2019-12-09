package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //static belongs to class no need to create onjects
    private static WebDriver driver;

    //if constructor is private
    //you cannot do Driver obj = new Driver()
    private Driver(){

    }
    //getter method
    //if switch statement complains on string parameter
    //change java version to 7+, at least 8
    //File--> Project Structure--> Set Project language level to at least 8 or above
    public  static WebDriver get(){
        //if webdriver object was not created yet
        if(driver==null){
            //create webdriver object based on browser value from properties file
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    //if browser factor is wrong stop test and throw exception
                    //no browser will be opened
                    throw new RuntimeException("Wrong Browser Type!");


            }
        }
        return driver;
    }
    public static void close() {
        //if driver still exist
        if(driver !=null){
            //close all browsers
            driver.quit();
            //destroy driver object garbage collector
            driver = null;
        }
    }


    }

