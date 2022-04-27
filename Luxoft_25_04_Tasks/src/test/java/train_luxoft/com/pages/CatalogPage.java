package train_luxoft.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.google.common.collect.Iterables.size;

public class CatalogPage extends CommonPage {
    WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        return this.driver.getCurrentUrl();
    }

    public WebDriver moveToPage(String arg0) {
        this.getElement(arg0).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public WebElement getElement(String name) {
        WebElement elem = null;
        switch (name) {
            case"Complex Programs":
                elem = driver.findElement(By.xpath("//ul[@class='addition-menu']/li[2]/a"));
                break;
            case"Search":
                elem = driver.findElement(By.xpath("//div[@class='search-item-catalog']/form/input"));
                break;
        }
        return elem;
    }

    public boolean isThereText(String search) {
        int i = size(driver.findElements(By.xpath("//*[contains(text()," + search + ")]")));
        return i > 1;
    }

}
