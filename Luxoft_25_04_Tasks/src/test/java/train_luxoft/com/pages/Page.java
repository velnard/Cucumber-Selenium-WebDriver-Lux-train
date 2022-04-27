package train_luxoft.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Page {
    public WebElement getElement(String name);
    public String getURL();
}
