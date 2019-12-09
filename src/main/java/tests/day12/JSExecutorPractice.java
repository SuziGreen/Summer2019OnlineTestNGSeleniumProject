package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutorPractice {
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");

    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            //move 500px down
            //parameters
            //x-y coordinate is horixontal pixel value that you want to scroll by.
            //y coordinate is the vertical "                                    "

            js.executeScript("window.scrollBy(0, 500)");
            BrowserUtils.wait(2);
        }

        BrowserUtils.wait(4);


    }

    @Test(description = "Scrolling with JSexecutor to specific element")
    public void test2() {
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);//for demo

        //js code from browser
        //var footer = document.getEmelentById('page-footer');
        //footer.scroolIntoView(true);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //script must scroll until link element is not visible
        //once link element is visible it will stop scrolling
        //arguments[0]=first weelement after comma(link)
        //arguments is an array of webElements after comma
        //arguments[0] = link webElement, it can be any web element
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(2);
    }

    @Test(description = "click with JS executor")
    public void test3() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //Example 1 is a begining of the phrase <a href='http:'>Example 1....</a>
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //argument[0[ = link1 web element
        //whenever regular sellenium methods are not working, use js executor
        //or for scrolling
        //arguments[0].click() is an alternative for link1.click()
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);
    }

    @Test(description = "Enter text with JS executor")
    public void test4() {
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));
        //to create jsexecutor object we need to cast webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //enter full name
        //.setAttribute('value', 'John Smith') its the same as name.sendKEys("John Smith");
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'Johm Smith')", name);

        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email);

        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", submitButton);

        BrowserUtils.wait(2);


    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}

