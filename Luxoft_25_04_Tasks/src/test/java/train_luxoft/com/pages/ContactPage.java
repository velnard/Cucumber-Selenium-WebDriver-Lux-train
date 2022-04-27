package train_luxoft.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.google.common.collect.Iterables.size;

public class ContactPage extends CommonPage{

    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String name) {
        WebElement elem = null;
        switch (name) {
            case"Moscow":
                elem = driver.findElement(By.xpath("//ul[@class='addition-menu']/li[1]/a"));
                break;
            case"Saint-Petersburg":
                elem = driver.findElement(By.xpath("//ul[@class='addition-menu']/li[2]/a"));
                break;
            case"Omsk":
                elem = driver.findElement(By.xpath("//ul[@class='addition-menu']/li[3]/a"));
                break;
        }
        return elem;
    }

    public String getURL() {
        return this.driver.getCurrentUrl();
    }
    public WebDriver moveToPage(String arg0) {
        this.getElement(arg0).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }
    public boolean isThereText(String search) {
        WebElement elem = null;
        int i = size(driver.findElements(By.xpath("//*[contains(text(),'" + search + "')]")));
        return i > 0;
    }
}
