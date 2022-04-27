package train_luxoft.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchedulePage extends CommonPage {

    WebDriver driver;

    public SchedulePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String name) {
        WebElement elem = null;
        switch (name) {
            case"Schedule":
                elem = driver.findElement(By.xpath("//ul[@class='addition-menu']/li[1]/a"));
                break;
            case"Free seminars":
                elem = driver.findElement(By.xpath("//ul[@class='addition-menu']/li[2]/a"));
                break;
            case"Online-courses":
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
        elem = driver.findElement(By.xpath("//*[contains(text(),'" + search + "')]"));
        if (elem == null) {
            return false;
        } else {
            return true;
        }
    }
}
