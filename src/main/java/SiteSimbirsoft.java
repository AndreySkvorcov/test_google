import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteSimbirsoft {
    private RemoteWebDriver driver;

    public SiteSimbirsoft(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String assertSignature() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'row text-center copyright']")));
        return element.getText();
    }
}
