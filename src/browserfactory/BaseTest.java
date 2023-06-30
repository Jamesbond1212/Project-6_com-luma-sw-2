package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        //Launch the Chrome browser
        driver = new ChromeDriver();

        // open Url into browser
        driver.get(baseUrl);

        // maximise the window
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser(){
        driver.quit();
    }
}
