import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.testng.annotations.Test;

import java.io.IOException;

public class ICEDescriptionsScrap extends BaseTest {
    private final String login = "admin"; //admin
    private final String password = "2020Int3lity!"; //E7$e58DpxYYesP_eyT
    private final String ics = "galina";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    @Test
    public void DescrScrap() throws InterruptedException, IOException {
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().navigateToMisc().gotoICEDesc().scrapICEDescriptions();
    }
}
