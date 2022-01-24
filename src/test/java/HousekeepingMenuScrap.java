import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.testng.annotations.Test;

import java.io.IOException;


public class HousekeepingMenuScrap extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private String directory = "C:\\Users\\MSI\\Desktop\\";
    private String file ="housekeepingCards.json";


    @Test(description = "Fill the descriptions")
    public void houskeepingScrap() throws InterruptedException, IOException {
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().navigateToHousekeeping().scrapCards(directory+file);
    }
}
