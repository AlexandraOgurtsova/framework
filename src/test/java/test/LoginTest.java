package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ConverseSneakerPage;
import service.UserCreator;

public class LoginTest extends CommonConditions{

    private final String expectedUsername =  "Hey, Alexandra";

    @Test
    public void loginAsLoggedInUser(){
        User testUser = UserCreator.withCredentialsFromProperty();
        String result = new ConverseSneakerPage(driver)
                .openSneakerPage()
                .logIntoAccount(testUser)
                .findUser();
        Assert.assertEquals(result, expectedUsername);
    }
}
