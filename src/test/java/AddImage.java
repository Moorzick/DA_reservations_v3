import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddImage extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);
    private String directory = "C:\\Users\\MSI\\Desktop\\";
    private String file="cat_question.jpg";
    private String name = "cat_question";
    private String keyWord = "cat";

    @Test(description = "Fill the descriptions")
    public void addImage() throws InterruptedException, IOException, ParseException {
        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().navigateToMediaLibrary().gotoImages().addImage().addFile(name, directory+file, keyWord);

    }
}
