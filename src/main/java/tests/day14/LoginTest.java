package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {
    @Ignore
    @Test
    public void test1(){
        //real url from properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.get()===>returns webdriver object
        //then we can call webdriver methods like get(), find element().....
        Driver.get().get(url);
        //print page title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();

    }
    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(3);



    }
}
