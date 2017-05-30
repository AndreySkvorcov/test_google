import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleSearch {
    private RemoteWebDriver driver;
    private By search_field = By.name("q");
    private By search = By.name("btnK");

    public GoogleSearch(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public Select_simbirsoft search(String input_search) {
        driver.findElement(search_field).sendKeys(input_search);
        driver.findElement(search).submit();
        return new Select_simbirsoft(driver);
    }
}
