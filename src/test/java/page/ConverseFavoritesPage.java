package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConverseFavoritesPage extends AbstractPage {

    public ConverseFavoritesPage(WebDriver driver){
        super(driver);
    }

    public String getFavoriteResult(){
        waitUntilPresenceOfElement(By.xpath("//div[@class='account-head__title flex flex-align-center']"));
        return waitUntilPresenceOfElement(By.xpath("//a[@class='product-tile__url link--underline']")).getText();
    }
}
