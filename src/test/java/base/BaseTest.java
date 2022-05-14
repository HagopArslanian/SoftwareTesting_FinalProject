package base;

import com.google.common.io.Files;
import constants.urls.Urls;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.AlibabaHomePage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    public AlibabaHomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
    }

    public AlibabaHomePage goHome(){
        driver = new ChromeDriver();
        homePage = new AlibabaHomePage(driver);
        driver.get(Urls.SUT_URL);
        driver.manage().window().maximize();
        return homePage;
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
