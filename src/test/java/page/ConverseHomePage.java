package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConverseHomePage extends AbstractPage {

    private final String HOME_URL = "https://www.converse.com/us";

    @FindBy(xpath="//button[@class='window-modal__close']")
    private WebElement closeBlockButton;

    @FindBy(xpath="//div[@class='header-search']")
    private WebElement openSearchButton;

    @FindBy(xpath="//input[@id='q']")
    private WebElement inputLocator;

    @FindBy(xpath="//p[@class='plp-search-results-null__text-helper__state-message text--bold']")
    private WebElement noFoundResultLocator;

    @FindBy(xpath="//div[@class='plp-actions__count']")
    private WebElement foundResultLocator;

    @FindBy(xpath="//h1[@class='pdp-primary-information__product-name display--small-up']")
    private WebElement foundConcretResultLocator;

    public ConverseHomePage(WebDriver driver) {
        super(driver);
    }

    public ConverseHomePage openHomePage(){
        driver.get(HOME_URL);
        return this;
    }

    public ConverseHomePage closeThePopUpWindow(){
        waitUntilElementIsClickable(closeBlockButton).click();
        return this;
    }

    public ConverseHomePage openSearch(){
        waitUntilVisibilityOf(openSearchButton).click();
        return this;
    }

    public ConverseHomePage searchInput(String input){
        waitUntilVisibilityOf(inputLocator).click();
        waitUntilVisibilityOf(inputLocator).sendKeys(input, Keys.RETURN);
        return this;
    }

    public String findConcretProductResult(){
        return waitUntilVisibilityOf(foundConcretResultLocator).getText();
    }

    public String noCorrectRequestResult(){
        return waitUntilVisibilityOf(noFoundResultLocator).getText();
    }

    public boolean isFindResult(){
        return waitUntilVisibilityOf(foundResultLocator).isEnabled();
    }
}
