package train_luxoft.com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static train_luxoft.com.steps.Hooks.strtDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/train_luxoft/com/features", //от корня проекта до папки
        glue = "train_luxoft.com.steps",    // выбирает из какой только папки выполняет фиатурес, от джава папки
        dryRun =false, // проверить компиляцию
        //strict =false, // что делать если упал один из сценариев: true отключает выполнение сценариев при первой же ошибке
        monochrome = false, // заставляет консоль быть одноцветной
        snippets = CucumberOptions.SnippetType.CAMELCASE, //как гегеняртся шаги
        tags = "@WebLuxoftTraining",         //помечаются всякие сценарии и шаги всякими метками (собственно тегами)
        plugin = {"pretty","html:cucumber-reports/cucumber-pretty","json:target/cucumber1.json"}
)
public class AppTest {
    @BeforeClass
    public static void startDriver(){
        strtDriver();
    }

    @AfterClass
    public static void tearDown(){
        Auxillary.driver.quit();
    }
}
