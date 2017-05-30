import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Main {

    RemoteWebDriver driver;

    @BeforeMethod
    public void run_server() {
        String hubURL = "http://192.168.60.177:5555/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName(BrowserType.FIREFOX);
        capabilities.setVersion("45.0");
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("https://www.google.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //неявное ожидание
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //явное ожидание
//        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("")));
    }

    @Test
    public void google_search() throws InterruptedException {
        GoogleSearch objGoogleSearch = new GoogleSearch(driver);
        Select_simbirsoft select_simbirsoft = objGoogleSearch.search("СимбирСофт");
        assertEquals("https://www.simbirsoft.com/ruru/", select_simbirsoft.transition_to_site());
        driver.get(select_simbirsoft.transition_to_site());
        SiteSimbirsoft simbirsoft = new SiteSimbirsoft(driver);
        assertEquals("© Copyright 2001-2017 SimbirSoft Ltd. All Rights Reserved", simbirsoft.assertSignature());
    }

    @AfterMethod
    public void browserClose() {
        driver.close();
    }
}
