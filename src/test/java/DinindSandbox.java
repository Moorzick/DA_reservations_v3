import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DinindSandbox extends BaseTest {

    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private String directory = "C:\\Users\\MSI\\Desktop\\";
    private String file = "housekeepingCards.json";

    private String imageDirectory = "C:\\Users\\user\\Desktop\\reports\\";
    private String image = "cat_question.jpg";

    private String imageName = "cat_question";

    private final String lang = "Ukrainian2";

    @Test(description = "Fill the descriptions")
    public void diningStuff() throws InterruptedException, IOException, ParseException {
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.icsHeader().navigateToStores().gotoDiningStore("Dining").gotoCategoryManager()
                .addCat("НявКатегорія001", "cat_question")
                .backToDining().addItem("КотячийТовар001", "12", "НявКатегорія001", "Exclusive - 10 %", "cat_question");


        Thread.sleep(5000);
    }
}
