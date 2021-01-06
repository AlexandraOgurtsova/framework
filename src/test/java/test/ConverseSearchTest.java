package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ConverseHomePage;


public class ConverseSearchTest extends CommonConditions {

    private final String expectedResultForSearchWithFailedTerms =  "Oops. We couldn't find anything that matches your search.";
    private final String expectedResultForSearchConcreteProduct ="Be Heard Chuck 70";

    @Test
    public void searchWithFailedTerms(){
        String resultOfSearch = new ConverseHomePage(driver)
                .openHomePage()
                .openSearch()
                .searchInput("GGGGGG")
                .noCorrectRequestResult();
        Assert.assertEquals(resultOfSearch, expectedResultForSearchWithFailedTerms);
    }

    @Test
    public void inputIntoSearchPartOfTheProductName(){
        boolean resultOfSearch = new ConverseHomePage(driver)
                .openHomePage()
                .openSearch()
                .searchInput("Holiday Sweater Chuck 70")
                .isFindResult();
        Assert.assertTrue(resultOfSearch);
    }

    @Test
    public void searchConcreteProduct(){
        String resultOfSearch = new ConverseHomePage(driver)
                .openHomePage()
                .openSearch()
                .searchInput("169912C_070")
                .findConcretProductResult();
        Assert.assertEquals(resultOfSearch, expectedResultForSearchConcreteProduct);
    }

}
