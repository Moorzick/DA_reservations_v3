import com.test.base.BaseTest;
import com.test.pages.Pages;
import com.test.tools.Tools;
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

    private String store = "New Retail Store";
    private String imageName = "cat_question";
    private String itemName = "НявТовар";
    private String upsellName = "НявАпсел";
    private int itemsNumber = 6;
    private String categoryName = "НявКатегорія001";
    private String upsellCategory = "НявКатегорія002";
    private String menuName="НявМеню001";
    private String upsellMenu = "НявАпселМеню002";
    private String subMenuName = "НявСубМеню001";

    private final String lang = "Ukrainian2";

    @Test(description = "Fill the descriptions")
    public void customStuff() throws InterruptedException, IOException, ParseException {

        String [] items = Tools.arrayPacker(itemName, itemsNumber);
        String [] upsels = Tools.arrayPacker(upsellName, itemsNumber);

        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.icsHeader().navigateToStores().gotoCustomStore(store)
                .addCustomCategory(categoryName, imageName)//.makeCustomUpsell(categoryName)
                .addItems(items, "20", categoryName, imageName)
                .gotoCustomMenuManager().addCustomMenu(menuName, imageName)
                .gotoCustomMenu(menuName).addCustomSubmenu(subMenuName, imageName)
                .goBackToCustomMenu()
                .backToCustomStore().editCustomMenu(menuName)
                .addItemsToMenu(items)
                .addCustomUpsellCategory(upsellCategory, imageName)
                .addItems(upsels, "15", upsellCategory, imageName)
                .gotoCustomMenuManager().addCustomMenu(upsellMenu, imageName)
                .gotoCustomMenu(upsellMenu).addCustomSubmenu(subMenuName, imageName)
                .goBackToCustomMenu().backToCustomStore().editCustomMenu(upsellMenu)
                .addItemsToMenu(upsels)
        ;


        Thread.sleep(10000);
    }
}