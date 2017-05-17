import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    @Test
    public void first_thread() throws MalformedURLException {
        String hubURL = "http://192.168.60.177:5555/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName(BrowserType.FIREFOX);
        capabilities.setVersion("45.0");
        capabilities.setPlatform(Platform.extractFromSysProperty("win7"));
        RemoteWebDriver driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        driver.get("https://www.google.com/");
        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //явное ожидание
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        element.sendKeys("Симбирсофт");
        element.submit();
        String expectedRes = "https://www.simbirsoft.com/ruru/";
        String actualRes = driver.findElement
                (By.xpath(".//div/cite[text()='https://www.simbirsoft.com/ruru/']")).getText();
        Assert.assertEquals(expectedRes, actualRes);
        driver.get("https://www.simbirsoft.com/ruru/");

        try {
            String expectedSignature = "© Copyright 2001-2017 SimbirSoft Ltd. All Rights Reserved";
            WebElement elementSignature = driver.findElement(By.xpath(".//*[@id='pointerOverlay']/footer/div/div[2]"));
            Assert.assertEquals(expectedSignature, elementSignature.getText());

        } catch (InvalidSelectorException e) {
            System.out.println("Аварийное завершение " + e);
            driver.close();
            driver.quit();
        }
        driver.close();
        driver.quit();
    }

    @Test
    public void second_thread() throws MalformedURLException {
        String hubURL = "http://192.168.60.177:5555/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName(BrowserType.FIREFOX);
        capabilities.setVersion("45.0");
        capabilities.setPlatform(Platform.extractFromSysProperty("win7"));
        RemoteWebDriver driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        driver.get("https://www.google.com/");
        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //явное ожидание
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        element.sendKeys("Симбирсофт");
        element.submit();
        String expectedRes = "https://www.simbirsoft.com/ruru/";
        String actualRes = driver.findElement
                (By.xpath(".//div/cite[text()='https://www.simbirsoft.com/ruru/']")).getText();
        Assert.assertEquals(expectedRes, actualRes);
        driver.get("https://www.simbirsoft.com/ruru/");

        try {
            String expectedSignature = "© Copyright 2001-2017 SimbirSoft Ltd. All Rights Reserved";
            WebElement elementSignature = driver.findElement(By.xpath(".//*[@id='pointerOverlay']/footer/div/div[2]"));
            Assert.assertEquals(expectedSignature, elementSignature.getText());

        } catch (InvalidSelectorException e) {
            System.out.println("Аварийное завершение " + e);
            driver.close();
            driver.quit();
        }
        driver.close();
        driver.quit();
    }
}
