package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    //which locator to use
    //#1 id
    //#2 css
    //#3 xpath
    //## whatever
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //let's find all buttons, and click on them one by one
        //why . is used instead of space  to separate 2 class names .btn.btn-primary
        //returns group of multiple elements
        // . means class name
        // # means ID
        List<WebElement>buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        //loop through list of buttons
        for(WebElement button:buttons){
            //click on every button one by one
            button.click();
            BrowserUtils.wait(2);
            //get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));
            //print a text of that message
            System.out.println(message.getText());

        }
        WebElement header = driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));
        System.out.println(p.getText());

        driver.quit();


    }
}
