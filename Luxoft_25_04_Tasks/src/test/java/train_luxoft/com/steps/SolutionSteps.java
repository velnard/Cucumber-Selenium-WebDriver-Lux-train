package train_luxoft.com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import train_luxoft.com.Auxillary;
import train_luxoft.com.pages.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static train_luxoft.com.pages.PageAlias.*;

public class SolutionSteps {

   /*private HomePage homePage = new HomePage(Auxillary.driver);
   private SchedulePage schedulePage = new SchedulePage(Auxillary.driver);
   private ContactPage contactPage = new ContactPage(Auxillary.driver);*/

    private String driverRightNow;
    private Map<PageAlias, Supplier<? extends CommonPage>> pages = new HashMap<>() {{
        put(HOME, ()->new HomePage(Auxillary.driver));
        put(SCHEDULE, ()->new SchedulePage(Auxillary.driver));
        put(CONTACT, ()->new ContactPage(Auxillary.driver));
        put(CATALOG, ()->new CatalogPage(Auxillary.driver));
    }};

    @Given("{string} is opened")
    public void homePageIsOpened(String arg0) {
        //Auxillary.driver.navigate().to("https://www.luxoft-training.ru/");
        Assertions.assertEquals("https://www.luxoft-training.ru/",pages.get(PageAlias.byDescription(arg0))
                .get().getURL());
        driverRightNow=arg0;
    }

    @When("user clicks on {string}")
    public void userClicksOn(String arg0) {
                Auxillary.driver = pages.get(PageAlias.byDescription(driverRightNow))
                        .get().moveToPage(arg0);
                driverRightNow=arg0;
    }

    @Then("^this buttons (displayed|not displayed) on '([^']*)' webpage$")
    @Step("^this buttons {arg0} on {page} webpage$")
    public void thisButtonsDisplayedOnNewWebpage(String arg0, String page, List<String> items) {
        if (arg0.equalsIgnoreCase("displayed"))
            for (String we : items) {
                Assertions.assertTrue(pages.get(PageAlias.byDescription(page))
                        .get().isElementDisplayed(we));
            }
        else {
            for (String we : items) {
                Assertions.assertFalse(pages.get(PageAlias.byDescription(page))
                        .get().isThereText(we));
            }
        }
    }

    @And("^clicks '([^']*)' and types '([^']*)'$")
    @Step("clicks {arg0} and types {search}$")
    public void clicksAndTypesSearch(String arg0, String search) {
        pages.get(PageAlias.byDescription(driverRightNow))
                .get().moveToPage(arg0);
        pages.get(PageAlias.byDescription(driverRightNow))
                .get().getElement("Search").sendKeys(search + Keys.ENTER);
        Auxillary.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Then("^this links (displayed|not displayed) on '([^']*)' webpage$")
    @Step("^this links {arg0} on {page} webpage$")
    public void thisLinksDisplayedOnClickedWebpage(String arg0, String page, List<String> items) {
            for (String we : items) {
                Assertions.assertTrue(pages.get(PageAlias.byDescription(page))
                        .get().isThereText(we));
            }

    }
}
