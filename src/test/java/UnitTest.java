import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class UnitTest {
    public static void main(String[] args) throws IOException, ParseException {
        String directory = "C:\\Users\\MSI\\Desktop\\";
        String file = "housekeepingCards.json";
        String thefile = directory+file;
        JSONArray cards =  new JSONArray(new FileReader(thefile).read());
        System.out.println(cards);

    }
}
