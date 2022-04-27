package train_luxoft.com.steps;


import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import train_luxoft.com.Auxillary;


import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 20)
    public static void strtDriver() {
        if (Auxillary.driver == null) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.setHeadless(false);
            Auxillary.driver = new ChromeDriver(options);
            Auxillary.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            Auxillary.driver.manage().window().maximize();
            Auxillary.driver.navigate().to("https://www.luxoft-training.ru/");
            Auxillary.driver.findElement(By.xpath("//a[@class='sign-in close-notice btn-primary']")).click();
        }
        else {
            Auxillary.driver.navigate().to("https://www.luxoft-training.ru/");}
    }


    @Before(value="@Ex2")
    public void beforeFirstScenario(Scenario scenario) {
        System.out.println(scenario.getName());
    }
    @Before(value="@Ex3")
    public void beforeSecondScenario(Scenario scenario) {
        System.out.println(scenario.getName());
    }
    @Before(value="@Ex4")
    public void beforeThirdScenario(Scenario scenario) {
        System.out.println(scenario.getName());
    }
    @After(order=500,value="@Ex3 and Ex2")
    public void afterSecondScenarioName(Scenario scenario){
        System.out.println(scenario.getName()+" was just finished. ID written on next line");
    }
    @After(order=200,value="@Ex3")
    public void afterSecondScenarioId(Scenario scenario){
        System.out.println(scenario.getId());
    }

    @After(value="@WebLuxoftTraining")
    public void makeScreenshot(Scenario scenario){
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) Auxillary.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); // ... and embed it in the report.
        }
    }



}
