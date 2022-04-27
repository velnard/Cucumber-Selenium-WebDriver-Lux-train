package train_luxoft.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonPage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        return this.driver.getCurrentUrl();
    }

    public WebElement getElement(String name) {
        WebElement elem = null;
        switch (name) {
            case"Schedule":
                elem = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div[1]/nav/ul/li[2]/a"));
                break;
            case"Contacts":
                elem = driver.findElement(By.xpath("//*[@id='Capa_1']"));
                break;
            case"Catalog":
                elem = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div[1]/nav/ul/li[1]/a"));
                break;
        }
        return elem;
    }

    public WebDriver moveToPage(String arg0) {
        this.getElement(arg0).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;
    }

    public boolean isThereText(String search) {
        WebElement elem = null;
        elem = driver.findElement(By.xpath("//*[contains(text(),'" + search + "')]"));
        if (elem == null) {
            return false;
        } else {
            return true;
        }
    }
}
