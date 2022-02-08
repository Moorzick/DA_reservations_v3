import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HousekeepingICSStoreMenuLocalize extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private String directory = "C:\\Users\\user\\Desktop\\ICSdata\\";
    private String file = "housekeepingCards.json";
    private final String lang = "Ukrainian2";

    @Test(description = "Fill the descriptions")
    public void houskeepingLocalize() throws InterruptedException, IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.icsHeader().navigateToHousekeeping().localizeCards(directory + file);
    }
}
