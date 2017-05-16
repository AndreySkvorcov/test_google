import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    @Test
    public static void testGoogle() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C://Users//user//Downloads//geckodriver.exe");
        System.out.println("gecko прошел");
        WebDriver firefoxDriver = new FirefoxDriver();
        System.out.println("Драйвер запущен");
        firefoxDriver.get("https://www.google.com/");
        WebElement element = firefoxDriver.findElement(By.name("q"));
        System.out.println("Нашли строку поиска");
        element.sendKeys("Симбирсофт");
        System.out.println("Написали в строке поиска 'Симбирсофт'");
        element.submit();
        System.out.println("нажали submit");
        WebElement site = firefoxDriver.findElement(By.xpath("//div/h3/a[text()='СимбирСофт']"));
        System.out.println(site.toString());
        Assert.assertEquals("СимбирСофт", site.findElement(By.linkText("СимбирСофт")));
//        System.out.println("На странице отображено: " + firefoxDriver.findElement(By.xpath("//div/h3/a")));
        firefoxDriver.close();
    }
}
