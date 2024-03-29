package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait; //explicit wait

    //table
    //thead- table header
    //tbody-table body(content)
    //tr-table row
    //td-table data
    //th-table header data
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver, 15);
        //I recommend to use this wait, for any element, not only web table
        //wait for presence of table 1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));

    }

    @Test(description = "Print table 1 data")
    public void test1() {
        //<table> stands for we table in HTML
        //table1 is id of first table
        //once we find this table as web element, we can print all text from there
        //if you are getting NoSuchElementException
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());

    }

    @Test(description = "Verify that number of columns in the first table equals to 6")
    public void test2() {
        int actualColumnNumber = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber = 6;
        Assert.assertEquals(actualColumnNumber, expectedColumnNumber);
    }

    @Test(description = "Verify that number of rows is equal to 5 ")
    public void test3() {
        int expectedRowCount = 5;
        int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        Assert.assertEquals(actualRowCount, expectedRowCount);
    }

    @Test(description = "Print all values from the 2nd row (excluding table header")
    public void test4() {
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }

    }

    @Test(description = "Print all values from the n-th row (excluding table header")
    public void test5() {
        //if index = 1, means 1st row
        //if we dont specify td index it will take all the td elements
        //in css we use space" ". in xpath // to get any child
        //or in css we use">", in xpath /, to get to direct child
        //css selector alternative; table[id='table'] tbody tr:nth-of-type(2) td
        //if index will exceed table size, you will not get any errors, list will be just empty
        //findElements() doesn't give NoSuchElementException, in any case
        int index = 1;
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());

        }

    }

    @Test(description = "Verify that email in the third row equals to jdoe@hotmail.com")
    public void test6() {
        int row = 3;//represents row#
        int column = 3;//represents column#
        //combination of tr and td index will give us specific cell  value
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + row + "]//td[" + column + "]"));
        String expectedEmail = "jdoe@hotmail.com";
        String actualEmail = cell.getText();
        Assert.assertEquals(actualEmail, expectedEmail);

    }

    /*
    Get all values from email column and verify that every value contains "@"
    if it doesnt contain"@" test fails.
     */
    @Test(description = "Verify all values from email column and verify all contains @")
    public void test7() {
        //get all emails
        //td[3] = third column
        //we are skipping tr, because we need data from all rows
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
        //loop through collection of emails
        for (WebElement email : emails) {
            System.out.println(email.getText());
            Assert.assertTrue(email.getText().contains("@"));
        }
    }

    /*
    Verify values are sorted from A-Z after clicking on last name
    1.Click on last name
    2.get all values from "last name" column
    3.verify that column is sorted in alphabetical order
     */
    @Test(description = "Verify that after clicking on last name, values will be sorted in alphabetic order")
    public void test8() {
        WebElement lastNameElement=driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']"));
        lastNameElement.click();
        //List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        List<WebElement>lastNames =  driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        for(int index =0; index<lastNames.size() -1; index++){
            String lastName = lastNames.get(index).getText();
            String followingLastName=lastNames.get(index+1).getText();
            Assert.assertTrue(lastName.compareTo(followingLastName)<0);
        }
    }

    @AfterMethod
        public void teardown () {
            driver.quit();
        }
    }



