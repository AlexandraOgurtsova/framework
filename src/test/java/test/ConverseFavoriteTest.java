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

public class ConverseFavoriteTest extends CommonConditions {

    private final String expectedResult =  "Chuck Taylor All Star";

    @Test
    public void addToFavoritesTest(){
        User testUser = UserCreator.withCredentialsFromProperty();
        String favoriteResult = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .closeThePopUpWindow()
                .logIntoAccount(testUser)
                .addProductToFavorites()
                .openFavoritePage()
                .getFavoriteResult();
        Assert.assertEquals(favoriteResult, expectedResult);
    }

}
