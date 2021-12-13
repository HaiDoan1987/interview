package demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FeatureTestSuite {

    WebDriver driver = null;

    String ExpectLoginSucessfully = "This is test message";

    @BeforeTest
    public void setThingUp() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get("https://app.payok.com.au/login");
    }

    @Test
    public  void firstTest() throws InterruptedException {
        Thread.sleep(5000);

        WebElement UserNameField = driver.findElement(By.id("userName"));

        //filling userName
        UserNameField.sendKeys("Test@test.com");

        WebElement UserPasswordField = driver.findElement(By.id("password"));

        UserNameField.sendKeys("123456789");

        // wait for login button to be enabled
        Thread.sleep(5000);

        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        loginButton.click();

        Thread.sleep(2000);

        // wait for successful message

        WebElement message = driver.findElement(By.id("loginSuccessFully"));

        Assert.assertEquals(message.getText(), ExpectLoginSucessfully);
    }

}
