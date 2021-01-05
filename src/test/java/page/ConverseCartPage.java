package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConverseCartPage extends AbstractPage {

    @FindBy(xpath="//button[@class='cart__item-action cart__item-remove body-type--pico link--primary']")
    private WebElement removeProductButton;

    @FindBy(xpath="//a[@class='cart__item-action cart__item-edit body-type--pico link--primary set--quickview-ready']")
    private WebElement editProductButton;

    @FindBy(id="variationDropdown-size")
    private WebElement editSizeProductButton;

    @FindBy(xpath = "//span[@class='variations__label-value text--capitalize']")
    private WebElement editColorProductButton;

    @FindBy(xpath = "//a[@class='swatchanchor selectable swatch--color set--events-ready'][5]")
    private WebElement selectColorLocator;

    @FindBy(xpath = "//option[text()= Men's 4 / Women's 6")
    private WebElement selectSizeLocator;

    @FindBy(id="add-to-cart-M9622_040")
    private WebElement updateButton;

    @FindBy(xpath = "//div[@class='cart__entry-item cart__entry-promo toggle-box']")
    private WebElement promocodLocator;

    @FindBy(xpath = "//input[@id='dwfrm_cart_couponCode']")
    private WebElement inputPromocodLocator;

    @FindBy(xpath = "//p[@class='coupon-entry__error field-error text--capitalize body-type--nano']")
    private WebElement noCorrectPromocodLocator;

    public ConverseCartPage(WebDriver driver){
        super(driver);
    }

    public ConverseCartPage removeProduct(){
        waitUntilElementIsClickable(removeProductButton).click();
        return this;
    }

    public ConverseCartPage editColorProduct(){
        waitUntilElementIsClickable(editProductButton).click();
        waitUntilVisibilityOf(editColorProductButton).click();
        waitUntilElementIsClickable(selectColorLocator).click();
        waitUntilElementIsClickable(updateButton).click();
        return this;
    }

    public boolean inputNoCorrectPromocod(String promocod){
        waitUntilVisibilityOf(promocodLocator).click();
        waitUntilVisibilityOf(inputPromocodLocator).sendKeys(promocod, Keys.RETURN);
        return waitUntilVisibilityOf(noCorrectPromocodLocator).isDisplayed();

    }

     public String getUpdateColor(){
         return waitUntilPresenceOfElement(By.xpath("//div[@data-attribute='color']/span[2]")).getText();
     }

    public String isRemove(){
        WebElement product = waitUntilPresenceOfElement(By.xpath("//h1[text()='You have (0) items in your cart.']"));
        return product.getText();
    }

    public String getCartResult(){
        return waitUntilPresenceOfElement(By.xpath("//a[@class='text--underline set--quickview-ready']")).getText();
    }
}
