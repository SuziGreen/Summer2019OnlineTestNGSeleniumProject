package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;


public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links?
        //every link has a tag name <a>
        //how to put all elements in one link?
        //how to find more than one element?
        //if list is empty, that means the element is not there
        //once it is empty we are assured the element is not present
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //to get size of link
        System.out.println("Number of Links: "+links.size());
        //what if i want to print text of all links, one by one
        //loop throught the collection of links
        for(WebElement WebElement : links){
            //prints text of every link
            if(!WebElement.getText().isEmpty())
            System.out.println(WebElement.getText());
        }
        driver.quit();
    }
}
