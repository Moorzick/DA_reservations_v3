import com.test.API.AuthProd;
import com.test.API.AuthStg;
import com.test.API.Calls;
import com.test.base.BaseTest;
import com.test.pages.Pages;
import com.test.tools.FlowController;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class mockPMSAutomated extends BaseTest {
    private final String login = "dmytro.lichman@intelity.com";
    private final String password = "Barsick5120";

    private final String env = "stg"; //"prod", "stg"

    private final String daProdUrl = "https://da.keyprprod.com";
    private final String daStgUrl = "https://da.keyprstg.com";
    private final String daDevUrl = "https://da.green.keypdev.com";

    private final String stgAPI = "https://api.keyprstg.com/v1";
    private final String prodAPI = "https://api.keyprprod.com/v1";

    private final String affiliate = "QA Base"; //"QA Base" Intelity Hotel
    private final String resName="Dmytro Lichman";
    private final String resEmail="testingrandomemail48@gmail.com"; //dmytro.lichman@intelity.com, cysinuje@ema-sofia.eu, testingrandomemail48@gmail.com
    private final String phoneNumber = "+3806877640928";
    private final String CC = "4111111111111111";
    private final String room = "101";

    private final String interviewID = "62c85193c5ef82b6eb56c67b";

    @Test(description = "prod res wcc and id ver")
    public void prodReservationWCCplusID() throws InterruptedException, IOException {
        String token="starting_value";
        String currentEnv = "";
        switch (env){
            case "stg":{
                openURL(daStgUrl);
                token = AuthStg.getToken();
                currentEnv=stgAPI;
                break;
            }
            case "prod":{
                openURL(daProdUrl);
                token = AuthProd.getToken();
                currentEnv=prodAPI;
            }
        }
        String affiliateID = Pages.loginPage()
                .authorize(login, password)
                .changeAffiliate(affiliate)
                .getAffiliateId();
        System.out.println(affiliateID);
        Pages.dAaffiliate().launchMockPMS();
        ArrayList<HashMap<String, String>> rooms = Calls.getRoomNumbers().get(currentEnv, token, affiliateID);
        HashMap<String, String> reservationData = new HashMap<>();
        reservationData.put("name", resName);
        reservationData.put("resEmail", resEmail);
        reservationData.put("phone", phoneNumber);
        reservationData.put("interview", interviewID);
        reservationData.put("room", room);
        reservationData.put("creditCard", CC);

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("rooms", rooms);
        parameters.put("env", currentEnv);
        parameters.put("token", token);
        parameters.put("affiliate", affiliateID);
        new FlowController().cycle(parameters, reservationData, CC);
    }
}
