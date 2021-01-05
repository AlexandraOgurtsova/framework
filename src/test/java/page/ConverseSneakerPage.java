package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConverseSneakerPage extends AbstractPage {
    private final String SNEAKERS_URL = "https://www.converse.com/shop/p/chuck-taylor-all-star-unisex-high-top-shoe/M9622_040.html?pid=M9006MP&dwvar_M9006MP_color=navy&dwvar_M9006MP_size=040&dwvar_M9006MP_width=standard&styleNo=M9622&pdp=true";

    @FindBy(xpath="//button[@class='window-modal__close']")
    private WebElement closeBlockButtonLocator;

    @FindBy(xpath="//div[@class='header-utility__item header-utility__item--icon header-user flex display--small-up']")
    private WebElement signInLocator;

    @FindBy(xpath="//input[@class='input-text validate-strict-email tab-hidden  required']")
    private WebElement inputLoginLocator;

    @FindBy(xpath="//input[@class='input-text tab-hidden  required']")
    private WebElement inputPasswordLocator;

    @FindBy(xpath="//button[@class='button button--primary set--full']")
    private WebElement signInButtonLocator;

    @FindBy(xpath="//div[@class='primary-information__favorite invert-theme']")
    private WebElement addToFavoriteButtonLocator;

    @FindBy(xpath="//a[@class='header-favorites__link flex']")
    private WebElement goToFavoriteButtonLocator;

    @FindBy(xpath="//button[@class='minicart__header-action minicart__header-action-close']")
    private WebElement closeItemsInCartButtonLocator;

    @FindBy(xpath="//a[@class='header-utility__item--icon minicart__link flex']")
    private WebElement goToCartButtonLocator;

    public ConverseSneakerPage(WebDriver driver){
        super(driver);
    }

    public ConverseSneakerPage openSneakerPage(){
        driver.get(SNEAKERS_URL);
        return this;
    }

    public ConverseSneakerPage closeThePopUpWindow(){
        waitUntilElementIsClickable(closeBlockButtonLocator).click();
        return this;
    }

    public ConverseSneakerPage logIntoAccount(User testData){
        waitUntilVisibilityOf(signInLocator).click();
        waitUntilVisibilityOf(inputLoginLocator).sendKeys(testData.getLogin());
        waitUntilVisibilityOf(inputPasswordLocator).sendKeys(testData.getPassword());
        waitUntilElementIsClickable(signInButtonLocator).click();

        waitUntilPresenceOfElement(By.xpath("//span[text()='Hey, Alexandra']"));
        return this;
    }

    public ConverseSneakerPage addProductToFavorites(){
        WebElement addToFavoriteButton = waitUntilVisibilityOf(addToFavoriteButtonLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(addToFavoriteButton).click().build().perform();
        addToFavoriteButton.click();

        waitUntilPresenceOfElement(By.cssSelector(".favorite-action__add"));
        return this;
    }

    public ConverseFavoritesPage openFavoritePage(){
        waitUntilElementIsClickable(goToFavoriteButtonLocator).click();;
        return new ConverseFavoritesPage(driver);
    }

    public ConverseSneakerPage addProductToCart(){
        waitUntilPresenceOfElement(By.xpath("//button[@class='button button--primary button--add-to-cart-pdp set--full set--themeable']")).click();
        return this;
    }

    public  ConverseSneakerPage closeItemsInCart(){
        waitUntilElementIsClickable(closeItemsInCartButtonLocator).click();
        return this;
    }

    public ConverseCartPage openCartPage(){
        waitUntilElementIsClickable(goToCartButtonLocator).click();
        return new ConverseCartPage(driver);
    }

    public String findUser(){
        return waitUntilPresenceOfElement(By.xpath("//span[text()='']")).getText();
    }
}
