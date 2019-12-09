package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeClass//runs only once before beforeMethod and before all tests
    public void beforeClass(){
        System.out.println("Before Class!");
    }
    //runs only once after afterMethod, and after all tests
    @AfterClass
    public void afterClass(){
        System.out.println("After Class!");
    }

    @BeforeMethod
    //@beforeMethod will automatically run before each method
    public void setup(){
        //some code that will be running before every test, like: test1, test2, test3....
        System.out.println("Before method");
    }
    @AfterMethod
    //runs automatically after every test
    public void teardown(){
        System.out.println("After Method!");

    }

    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test 2!");
    }
    @Test
    public void test3(){
        System.out.println("Test 3!");
    }
}
