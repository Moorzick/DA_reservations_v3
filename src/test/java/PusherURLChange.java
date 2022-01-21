import com.test.base.BaseTest;
import com.test.pages.*;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

public class PusherURLChange extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.23.0";

    private final String pusherURL = "https://acb857a8ab0f.ngrok.io";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    @Test(description = "Pusher URL change")
    public void pshrURLChng() throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoHotelSetup();
        Pages.icsHotelSetup().gotoAdvancedSettings(icsURL);
        Pages.icsAdvancedConfigs().setPusherURL(String.format("%s/api", pusherURL));
    }
}