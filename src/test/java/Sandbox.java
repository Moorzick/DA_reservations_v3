import com.test.base.BaseTest;
import com.test.pages.Pages;
import com.test.tools.Tools;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Sandbox extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private String directory = "C:\\Users\\user\\Desktop\\ICSData\\";
    private String file = "localAttractionsUA.json";

    private String imageDirectory = "C:\\Users\\user\\Desktop\\reports\\";
    private String image = "cat_question.jpg";

    private String imageName = "cat_question";


    private final String lang = "Ukrainian2";

    @Test(description = "Fill the descriptions")
    public void someStuff() throws InterruptedException, IOException, ParseException {

        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        //Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.mMenu().openTransportation(4);

        Thread.sleep(10000);
    }
}
