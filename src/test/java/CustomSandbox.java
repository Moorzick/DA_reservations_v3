import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class CustomSandbox extends BaseTest {

    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private String directory = "C:\\Users\\MSI\\Desktop\\";
    private String file = "housekeepingCards.json";

    private String imageDirectory = "C:\\Users\\user\\Desktop\\reports\\";
    private String image = "cat_question.jpg";

    private String imageName = "cat_question";
    private String itemName = "НявКастом";
    private int itemsNumber = 6;
    private String categoryName = "НявКатегорія001";
    private String menuName="НявМеню001";
    private String subMenuName = "НявСубМеню001";
    private ArrayList<String> itemNames = new ArrayList<>();

    private final String lang = "Ukrainian2";

    @Test(description = "Fill the descriptions")
    public void customStuff() throws InterruptedException, IOException, ParseException {
        for (int i=0; i<itemsNumber; i++){
            if (0<=i && i<100){
                itemNames.add(itemName+"00"+(i+1));
            }
        }
        String [] items = new String[itemNames.size()];
        items = itemNames.toArray(items);

        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.icsHeader().navigateToStores().gotoCustomStore("Mini Bar").gotoCustomCategories()
                .addCustomCat(categoryName, imageName)//.makeUpsell(categoryName)
                .backToCustomStore().addItems(items, "20", categoryName, imageName)
                .gotoCustomMenuManager().addCustomMenu(menuName, imageName)
                .gotoCustomMenu(menuName).addCustomSubmenu(subMenuName, imageName)
                .goBackToCustomMenu()
                .backToCustomStore()//.editLaundryMenu(menuName)
                //.addItems(items)
        ;


        Thread.sleep(10000);
    }
}
