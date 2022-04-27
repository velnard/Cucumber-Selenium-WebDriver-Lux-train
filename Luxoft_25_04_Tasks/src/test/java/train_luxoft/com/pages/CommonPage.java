package train_luxoft.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class CommonPage implements Page{

    @Override
    public abstract WebElement getElement(String name);
    @Override
    public abstract String getURL();
    public boolean isElementDisplayed(String name){
        WebElement elem = getElement(name);
        if (elem!=null){
        return getElement(name).isDisplayed();}
        else return false;
    }
    public abstract WebDriver moveToPage(String arg0);
    public abstract boolean isThereText(String search);

}
