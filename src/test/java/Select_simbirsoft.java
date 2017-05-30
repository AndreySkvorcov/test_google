import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select_simbirsoft {

    private RemoteWebDriver driver;

    public Select_simbirsoft(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String transition_to_site() {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='rso']/div[1]//cite")));
        return element.getText();
        //(//*[@id='rso']//a)[1]/text()
        //.//*[@id='rso']/div[1]//div/cite/text()
        //(//*[@id='rso']//a)[@href = "https://www.simbirsoft.com/ruru/"]/text()
    }

}
