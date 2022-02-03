import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ICEDescriptionsFill extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    String directoryPath = "C:\\Users\\user\\Desktop\\ICSdata\\";
    String fileName = "ICEDescriptionsMerged.json";
    String lang = "Ukrainian2";

    @Test
    public void DescrFill() throws InterruptedException, IOException, ParseException {
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.icsHeader().navigateToMisc().gotoICEDesc().fillICEDescs(directoryPath+fileName);
    }
}
