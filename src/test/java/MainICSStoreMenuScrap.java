import com.test.base.BaseTest;
import com.test.pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

public class MainICSStoreMenuScrap extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";

    private final String language2add="Ukrainian2";
    private final String cultCode = "ua-UA";

    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    @Test(description = "Fill the descriptions")
    public void iceDescrScrap() throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        /*Pages.icsHeader().navigateToSystemFunctions()
                .goToLang()
                .addLang(language2add, cultCode)
                .deleteLang(language2add);
        Pages.icsHeader().navigateToMisc().gotoLanguage().activateLang(language2add);*/
        Pages.icsHeader().navigateToMainMenu().switch2Frame().scrapItems();

        //Pages.icsHeader().switchLang(language2add);

        //Pages.icsHeader().navigateToMainMenu().

        Thread.sleep(5000);
    }
}