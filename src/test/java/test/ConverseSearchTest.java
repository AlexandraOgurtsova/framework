package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.ConverseHomePage;
import page.ConverseSneakerPage;

public class ConverseSearchTest extends CommonConditions {

    private final String expectedResult =  "Oops. We couldn’t find anything that matches your search.";
    private final String expectedProduct ="Be Heard Chuck 70";

    @Test
    public void searchWithFailedTerms(){
        String result = new ConverseHomePage(driver)
                .openHomePage()
                .closeThePopUpWindow()
                .openSearch()
                .searchInput("вечерело")
                .noCorrectRequestResult();
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void inputIntoSearchPartOfTheProductName(){
        boolean result = new ConverseHomePage(driver)
                .openHomePage()
                .openSearch()
                .searchInput("Holiday Sweater Chuck 70")
                .isFindResult();
        Assert.assertTrue(result);
    }

    @Test
    public void searchConcreteProduct(){
        String result = new ConverseHomePage(driver)
                .openHomePage()
                .openSearch()
                .searchInput("169912C_070")
                .findConcretProductResult();
        Assert.assertEquals(result, expectedProduct);
    }

}
