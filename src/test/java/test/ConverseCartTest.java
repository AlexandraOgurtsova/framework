package test;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.ConverseSneakerPage;
import service.UserCreator;

public class ConverseCartTest extends CommonConditions {

    private final String expectedResult =  "Chuck Taylor All Star";
    private final String productRemove =  "You have (0) items in your cart.";
    private final String expectedColor =  "Navy";
    private final String expectedUserName =  "Hey, Alexandra";

    @Test
    public void removeProductFromCartTest(){
        String cartResult = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .addProductToCart()
                .closeItemsInCart()
                .openCartPage()
                .removeProduct()
                .isRemove();
        Assert.assertEquals(cartResult, productRemove);
    }

    @Test
    public void addToCartTest(){
        String cartResult = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .closeThePopUpWindow()
                .addProductToCart()
                .closeItemsInCart()
                .openCartPage()
                .getCartResult();
        Assert.assertEquals(cartResult, expectedResult);
    }


    @Test
    public void editColorFromCartTest() {
        String updateSize = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .addProductToCart()
                .closeItemsInCart()
                .openCartPage()
                .editColorProduct()
                .getUpdateColor();
        Assert.assertEquals(updateSize, expectedColor);
    }

    @Test
    public void inputNoCorrectPromocodTest(){
        boolean result = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .addProductToCart()
                .closeItemsInCart()
                .openCartPage()
                .inputNoCorrectPromocod("333");
        Assert.assertTrue(result);
    }

    @Test
    public void filesCookingTest(){
        User testUser = UserCreator.withCredentialsFromProperty();
        String cartResult = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .addProductToCart()
                .closeItemsInCart()
                .logIntoAccount(testUser)
                .openCartPage()
                .getCartResult();
        Assert.assertEquals(cartResult, expectedResult);
    }

    @Test
    public void loginAsLoggedInUser(){
        User testUser = UserCreator.withCredentialsFromProperty();
        String result = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .logIntoAccount(testUser)
                .findUser();
        Assert.assertEquals(result, expectedUserName);
    }
}
