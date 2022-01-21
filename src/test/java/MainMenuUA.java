import com.test.base.BaseTest;
import com.test.pages.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class MainMenuUA extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";

    private final String language2add="Ukrainian2";
    private final String cultCode = "ua-UA";

    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);


    @Test(description = "Fill the descriptions")
    public void iceDescrUA() throws InterruptedException, IOException, ParseException {
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().navigateToSystemFunctions()
                .goToLang()
                .addLang(language2add, cultCode);
        Pages.icsHeader().navigateToMisc().gotoLanguage().activateLang(language2add);
        Pages.icsHeader().switchLang(language2add);
        Pages.icsWelcomeMenu().gotoContent().switch2Frame();
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader("C:\\Users\\user\\Desktop\\mainMenuCards.json"));
        for (int i=1; i<=data.size(); i++){
            JSONObject json = (JSONObject) data.get(i);
            int index = Integer.valueOf(json.get("index").toString());
            Pages.mMenu().selectCard(index).fillCard(json);
        }
        //Pages.icsHeader().navigateToMainMenu()
        Thread.sleep(5000);
    }
}