package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.chrome.driver", "/Users/bharatbhatt/Desktop/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/bharatbhatt/Desktop/Java%20Projects/task8_1P/webservice1/src/main/java/web/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("ahsan");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ahsan_pass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("01-01-1980");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        WebElement statusElement = driver.findElement(By.id("login-status"));
        String status = statusElement.getText();
        Assert.assertEquals("success", status);

        driver.close();
    }

    @Test
    public void testLoginFailure() {
        System.setProperty("webdriver.chrome.driver", "/Users/bharatbhatt/Desktop/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/bharatbhatt/Desktop/Java%20Projects/task8_1P/webservice1/src/main/java/web/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("Jacob");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("Jacob_Password");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("21-11-1983");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        WebElement statusElement = driver.findElement(By.id("login-status"));
        String status = statusElement.getText();
        Assert.assertEquals("fail", status);

        driver.close();
    }

    @Test
    public void testLoginNullValues() {
        System.setProperty("webdriver.chrome.driver", "/Users/bharatbhatt/Desktop/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/bharatbhatt/Desktop/Java%20Projects/task8_1P/webservice1/src/main/java/web/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        WebElement statusElement = driver.findElement(By.id("login-status"));
        String status = statusElement.getText();
        Assert.assertEquals("fail", status);

        driver.close();
    }

    @Test
    public void testLoginMismatchedValues() {
        System.setProperty("webdriver.chrome.driver", "/Users/bharatbhatt/Desktop/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/bharatbhatt/Desktop/Java%20Projects/task8_1P/webservice1/src/main/java/web/login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("ahsan");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ahsanahsan");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15-10-1990");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        WebElement statusElement = driver.findElement(By.id("login-status"));
        String status = statusElement.getText();
        Assert.assertEquals("fail", status);

        driver.close();
    }
}
