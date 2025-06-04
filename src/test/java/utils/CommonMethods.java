package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer{
    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {

        //Choose browsers
        switch (ConfigReader.read("browser")) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                //driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }

        //open browser, initiate an implict wait, open site
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
    }

    //close the browser
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }

    public void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public WebDriverWait getwait(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public void waitForElementToBeclickable(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        waitForElementToBeclickable(element);
        element.click();
    }

    public String getTimeStamp(String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILE_PATH +
                    fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return picByte;
    }
}



















