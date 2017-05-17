import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "profileName")
    private WebElement username;

    @FindBy(linkText = "Выход")
    private WebElement exit;

    @FindBy(className = "menu_iten")
    private List<WebElement> menuItems;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
