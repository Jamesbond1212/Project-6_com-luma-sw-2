package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//li[@class = 'authorization-link']")).click();
        driver.findElement(By.id("email")).sendKeys("casinoroyaljamesbond7@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Bond007%");
        driver.findElement(By.id("send2")).click();
        String expected = "Welcome, James Bond!";
        String actual = driver.findElement(By.xpath("//span[text() = 'Welcome, James Bond!']")).getText();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        driver.findElement(By.xpath("//li[@class = 'authorization-link']")).click();
        driver.findElement(By.id("email")).sendKeys("xypatel@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Prime@123");
        driver.findElement(By.id("send2")).click();
        String expected = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actual = driver.findElement(By.xpath("//div[text() = 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.xpath("//li[@class = 'authorization-link']")).click();
        driver.findElement(By.id("email")).sendKeys("casinoroyaljamesbond8@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Bond008%");
        driver.findElement(By.id("send2")).click();
        String expected = "Welcome, James Bond!";
        String actual = driver.findElement(By.xpath("//span[text() = 'Welcome, James Bond!']")).getText();
        Assert.assertEquals(expected, actual);
        driver.findElement(By.xpath("//button[@class = 'action switch']")).click();
        driver.findElement(By.xpath("//li[@class = 'authorization-link']")).click();

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
