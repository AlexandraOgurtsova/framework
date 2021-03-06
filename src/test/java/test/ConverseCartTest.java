package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ConverseSneakerPage;
import service.UserCreator;

public class ConverseCartTest extends CommonConditions {

    private final String expectedResult =  "Chuck Taylor All Star";
    private final String productRemove =  "You have (0) items in your cart.";
    private final String expectedColor =  "Navy";

    @Test
    public void filesCookingTest(){
        User testUser = UserCreator.withCredentialsFromProperty();
        String cartResult = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .addProductToCart()
                .logIntoAccount(testUser)
                .openCartPage()
                .getCartResult();
        Assert.assertEquals(cartResult, expectedResult);
    }

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
        boolean inputNoCorrectPromocodResult = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .addProductToCart()
                .closeItemsInCart()
                .openCartPage()
                .inputNoCorrectPromocod("333");
        Assert.assertTrue(inputNoCorrectPromocodResult);
    }
}
