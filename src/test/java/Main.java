import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class Main {

    @Test
    public static void testGoogle() throws Exception {
        String platform_name = "win7";
        String browser_name = "firefox";
        String browser_version = "53";

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setPlatform(Platform.extractFromSysProperty(platform_name));
        cap.setBrowserName(browser_name);

        System.setProperty("webdriver.gecko.driver", "C://Users//user//Downloads//geckodriver.exe");
        RemoteWebDriver firefoxDriver = new RemoteWebDriver(new URL("http://localhost:4444/grid/console"), cap);
        firefoxDriver.get("https://www.google.com/");
        Thread.sleep(5000);
        WebElement element = firefoxDriver.findElement(By.name("q"));
        element.sendKeys("Симбирсофт");
        Thread.sleep(5000);
        element.submit();
        Thread.sleep(5000);
//        WebElement site = firefoxDriver.findElement(By.xpath("//div/h3/a/text()"));
//        System.out.println(site.toString());
//        Assert.assertEquals("СимбирСофт", site.toString());
//        System.out.println("На странице отображено: " + firefoxDriver.findElement(By.xpath("//div/h3/a")));
        firefoxDriver.quit();
    }
}
