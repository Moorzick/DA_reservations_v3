import com.test.base.BaseTest;
import com.test.pages.Pages;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class DinindSandbox extends BaseTest {

    private final String login = "dmytro.lichman@intelity.com"; //"admin"; //
    private final String password = "Barsick5120"; //"2020Int3lity!"; //"Barsick5120";
    private final String ics = "4.28.0";
    String icsURL = String.format("https://qaweb.icemain.com/ICS/QA/%s", ics);

    private String directory = "C:\\Users\\user\\Desktop\\ICSdata\\";
    //private String file = "housekeepingCards.json";
    private String file = "deliveryOptions.json";

    private String imageDirectory = "C:\\Users\\user\\Desktop\\reports\\ICSdata\\";
    private String image = "cat_question.jpg";

    private String imageName = "cat_question";
    private String itemName = "НявАпсел";
    private int itemsNumber = 6;
    private String categoryName = "НявКатегорія002";
    private String menuName="НявМеню002";
    private String subMenuName = "НявСубМеню001";
    private ArrayList<String> itemNames = new ArrayList<>();

    private final String lang = "Ukrainian2";

    @Test(description = "Fill the descriptions")
    public void diningStuff() throws InterruptedException, IOException, ParseException {
/*        for (int i=0; i<itemsNumber; i++){
            if (0<=i && i<100){
                itemNames.add(itemName+"00"+(i+1));
            }
        }
        String [] items = new String[itemNames.size()];
        items = itemNames.toArray(items);*/

        openURL(icsURL);
        Pages.loginPage().authorization(login, password);
        Pages.icsWelcomeMenu().gotoContent();
        Pages.icsHeader().switchLang(lang).gotoContent();
        Pages.icsHeader().navigateToStores();
        int amount = Pages.stores().getStoresCount();
        System.out.println(amount);
        for (int i=1; i<=amount; i++){
            if (!Pages.stores().editStore(i).check4Spa()){
                Pages.stores().editStore(i).deliveryOptions().fillAllFromFile(directory+file, imageName).back();
            }
            else {
                System.out.println("Skipping due to spa");
            }
        }
                /*.gotoDiningStore("Dining").gotoDiningCategoryManager()
                .addDiningCat(categoryName, imageName).makeDiningUpsell(categoryName)
                .backToDiningStore().addItems(items, "12", categoryName, "Exclusive - 10 %", imageName)
                .gotoDiningMenuManager().addDiningSection(menuName, imageName).addDailySchedule(menuName, 4, 00, "AM", 10, 00, "AM")
                .gotoDiningMenu(menuName).addDiningSubmenu(subMenuName, imageName)
                .gotoDiningSubmenu(subMenuName).addDiningItems(items)*/
        ;


        System.out.println("Ending wait");
        Thread.sleep(10000);
    }
}
